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

	public List<Medjustanica> getMedjustaniceByLinijaID(int linijaID) {
		return this.medjustanicaRepository.getMedjustaniceByLinijaID(linijaID);
	}

}
