package rs.ac.bg.fon.silab.ZelezniceSrbije.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Stanica;
import rs.ac.bg.fon.silab.ZelezniceSrbije.repository.StanicaRepository;

@Service
@Transactional
public class StanicaService {
	@Autowired
	private StanicaRepository stanicaRepository;
	
	public List<Stanica> getAll() {
		System.out.println("Get all stations");
		return stanicaRepository.getAll();
	}
}
