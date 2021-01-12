package rs.ac.bg.fon.silab.ZelezniceSrbije.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Klijent;
import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Polazak;
import rs.ac.bg.fon.silab.ZelezniceSrbije.service.KlijentService;

@RestController
@RequestMapping("/api/klijent")
public class KlijentController {
	@Autowired
	private KlijentService klijentService;

	@GetMapping("/all")
	public List<Klijent> getAllKlijent() {
		return this.klijentService.getAllKlijent();
	}
	
	@PostMapping("/get")
	public Klijent getKlijentByEmailAndPassword(@RequestBody Klijent klijent) {
		return this.klijentService.getByEmailAndPassword(klijent.getEmail(), klijent.getLozinka());
	}
	@PostMapping("/getbyid")
	public Klijent getKlijentById(@RequestBody Klijent klijent) {
		return this.klijentService.getKlijentById(klijent.getId());
	}
	@PostMapping("/add")
	public Klijent addNewKlijent(@RequestBody Klijent klijent) {
		return this.klijentService.addNewKlijent(klijent);
	}

	
}
