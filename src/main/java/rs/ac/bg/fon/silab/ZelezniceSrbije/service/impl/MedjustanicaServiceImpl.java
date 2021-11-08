package rs.ac.bg.fon.silab.ZelezniceSrbije.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Medjustanica;
import rs.ac.bg.fon.silab.ZelezniceSrbije.repository.MedjustanicaRepository;
import rs.ac.bg.fon.silab.ZelezniceSrbije.service.MedjustanicaService;

@Service
@Transactional
public class MedjustanicaServiceImpl implements MedjustanicaService{
	
	@Autowired
	private MedjustanicaRepository medjustanicaRepository;
	
        @Override
	public List<Medjustanica> getAll() {
		return this.medjustanicaRepository.getAll();
	}


        @Override
	public List<Medjustanica> getMedjustaniceByLinijaID(int linijaID) {
		return this.medjustanicaRepository.getMedjustaniceByLinijaID(linijaID);
	}

        @Override
	public Medjustanica add(Medjustanica m) {
		return this.medjustanicaRepository.save(m);
	}

        @Override
	public int update(Medjustanica m) {
		return this.medjustanicaRepository.update(m.getRedniBroj(),m.getLinija().getLinijaID(),m.getStanica().getStanicaID());
	}
	
        @Override
	public int delete(Medjustanica m) {
		return this.medjustanicaRepository.delete(m.getMedjustanicaID());
	}
	

}
