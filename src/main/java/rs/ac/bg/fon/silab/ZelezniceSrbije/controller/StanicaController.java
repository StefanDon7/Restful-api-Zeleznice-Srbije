package rs.ac.bg.fon.silab.ZelezniceSrbije.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public List<Stanica> getAll() {
		return this.stanicaService.getAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<Stanica> add(@RequestBody Stanica stanica) {
		Stanica s=this.stanicaService.add(stanica);
		return new ResponseEntity<Stanica>(s, HttpStatus.OK);
	}
		
}	
