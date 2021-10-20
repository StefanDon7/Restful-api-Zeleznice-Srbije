package rs.ac.bg.fon.silab.ZelezniceSrbije.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Mesto;
import rs.ac.bg.fon.silab.ZelezniceSrbije.repository.MestoRepository;

@Service
@Transactional
public class MestoService {

	@Autowired
	private MestoRepository mestoRepository;
	

	public List<Mesto> getAllMesto() {
		System.out.println("getAllMesto");
		return mestoRepository.findAll();
	}
}
