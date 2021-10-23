package rs.ac.bg.fon.silab.ZelezniceSrbije.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Medjustanica;
import rs.ac.bg.fon.silab.ZelezniceSrbije.repository.MedjustanicaRepository;

@Service
@Transactional
public class MedjustanicaService {
	
	@Autowired
	private MedjustanicaRepository medjustanicaRepository;
	
	public List<Medjustanica> getAll() {
		return this.medjustanicaRepository.getAll();
	}


	public List<Medjustanica> getMedjustaniceByLinijaID(int linijaID) {
		return this.medjustanicaRepository.getMedjustaniceByLinijaID(linijaID);
	}

	public Medjustanica add(Medjustanica m) {
		return this.medjustanicaRepository.save(m);
	}

	public int update(Medjustanica m) {
		return this.medjustanicaRepository.update(m.getRedniBroj(),m.getLinija().getLinijaID(),m.getStanica().getStanicaID());
	}
	
	public int delete(Medjustanica m) {
		return this.medjustanicaRepository.delete(m.getMedjustanicaID());
	}
	

}
