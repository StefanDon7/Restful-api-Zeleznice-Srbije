package rs.ac.bg.fon.silab.ZelezniceSrbije.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Polazak;
import rs.ac.bg.fon.silab.ZelezniceSrbije.service.PolazakService;


@RestController
@RequestMapping("/api/polazak")
public class PolazakController {

	@Autowired
	private PolazakService polazakService;

	@GetMapping("/all")
	public List<Polazak> getAll() {
		return this.polazakService.getAll();
	}
	
	@GetMapping("/{datum}")
	public List<Polazak> getAllByDate(@PathVariable("datum") String datum) {
		return this.polazakService.getAllByDate(datum);
	}
	
	@GetMapping("/{datum}/{stanicaPocetna}/{stanicaKrajnja}")
	public List<Polazak> getAllByDateStartAndFinalStation(@PathVariable("datum") String datum, @PathVariable("stanicaPocetna") String stanicaPocetna, @PathVariable("stanicaKrajnja") String stanicaKrajnja){
		return this.polazakService.getAllByDateStartAndFinalStation(datum,stanicaPocetna,stanicaKrajnja);
	}
}
