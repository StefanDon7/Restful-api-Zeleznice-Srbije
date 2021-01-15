package rs.ac.bg.fon.silab.ZelezniceSrbije.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Klijent;
import rs.ac.bg.fon.silab.ZelezniceSrbije.repository.KlijentRepository;

@Service
@Transactional
public class KlijentService {
	
	@Autowired
	private KlijentRepository klijentRepository;
	
	public List<Klijent> getAllKlijent() {
		System.out.println("getAllUsers");
		return klijentRepository.getAllKlijent();
	}
	
	public Klijent getByEmailAndPassword(String email, String password) {
		System.out.println("get "+email+" "+password);
		return klijentRepository.getByEmailAndPassword(email, password);
	}
	public Klijent getKlijentById(int id) {
		System.out.println("get "+id);
		return klijentRepository.getKlijentById(id);
	}

	public Klijent addNewKlijent(Klijent klijent) {
		System.out.println("add new klijent: "+klijent);
		return klijentRepository.saveAndFlush(klijent);
	}

	public String getKlijentByEmail(String email) {
		System.out.println("getKlijentByEmail");
		return klijentRepository.getKlijentByEmail(email);
	}

	
}
