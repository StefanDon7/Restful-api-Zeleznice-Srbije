package rs.ac.bg.fon.silab.ZelezniceSrbije.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Stanica;
import rs.ac.bg.fon.silab.ZelezniceSrbije.service.StanicaService;

@RestController
@RequestMapping("/api/stanica")
public class StanicaController {
	
	@Autowired
	private StanicaService stanicaService;

	@GetMapping("/all")
	public List<Stanica> getAllKlijent() {
		return this.stanicaService.getAll();
	}
		
}	
