package rs.ac.bg.fon.silab.ZelezniceSrbije.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Stanica;
import rs.ac.bg.fon.silab.ZelezniceSrbije.repository.StanicaRepository;
import rs.ac.bg.fon.silab.ZelezniceSrbije.service.StanicaService;

@Service
@Transactional
public class StanicaServiceImpl implements StanicaService{
	@Autowired
	private StanicaRepository stanicaRepository;
	
        @Override
	public List<Stanica> getAll() {
		System.out.println("Get all stations");
		return stanicaRepository.getAll();
	}

        @Override
	public Stanica add(Stanica stanica) {
		System.out.println("add new stanica: "+stanica);
		return stanicaRepository.saveAndFlush(stanica);
	}

	
}
