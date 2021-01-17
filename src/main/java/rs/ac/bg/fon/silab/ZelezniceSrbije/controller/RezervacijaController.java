package rs.ac.bg.fon.silab.ZelezniceSrbije.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Klijent;
import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Polazak;
import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Rezervacija;
import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.compositeKey.RezervacijaCompositeKey;
import rs.ac.bg.fon.silab.ZelezniceSrbije.service.RezervacijaService;

@RestController
@RequestMapping("/api/rezervacija")
public class RezervacijaController {
	
	@Autowired
	private RezervacijaService rezervacijaService;
	
	@PostMapping("/klijent/rezervacije")
	public List<Rezervacija> getRezervacijeByUserID(@RequestBody Klijent klijent) {
		return rezervacijaService.getRezervacijeByUserID(klijent.getKlijentID());
	}
	@PostMapping("/add")
	public Rezervacija addRezervacija(@RequestBody RezervacijaCompositeKey rezervacijaCompositeKey) {
		Rezervacija rezervacija=new Rezervacija(new RezervacijaCompositeKey(rezervacijaCompositeKey.getKlijentID(),rezervacijaCompositeKey.getPolazakID()), 
												new  Klijent(rezervacijaCompositeKey.getKlijentID()), 
												new Polazak(rezervacijaCompositeKey.getPolazakID()), 
												new Date());
		return rezervacijaService.addRezervacija(rezervacija);
	}
	@PostMapping("/get")
	public Rezervacija getRezervacija(@RequestBody RezervacijaCompositeKey rezervacijaCompositeKey) {
		Rezervacija rezervacija=new Rezervacija(new RezervacijaCompositeKey(rezervacijaCompositeKey.getKlijentID(),rezervacijaCompositeKey.getPolazakID()), 
				new  Klijent(rezervacijaCompositeKey.getKlijentID()), 
				new Polazak(rezervacijaCompositeKey.getPolazakID()), 
				new Date());
		System.out.println("Saljem upit za rezervaciju klijentID:"+rezervacija.getKlijent().getKlijentID()+" polazakID:"+rezervacija.getPolazak().getPolazakID());
	return rezervacijaService.getRezervacije(rezervacija);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody RezervacijaCompositeKey rezervacijaCompositeKey) {
		Rezervacija rezervacija=new Rezervacija(new RezervacijaCompositeKey(rezervacijaCompositeKey.getKlijentID(),rezervacijaCompositeKey.getPolazakID()), 
				new  Klijent(rezervacijaCompositeKey.getKlijentID()), 
				new Polazak(rezervacijaCompositeKey.getPolazakID()), 
				new Date());
		 rezervacijaService.delete(rezervacija);
	
	}
	
}
