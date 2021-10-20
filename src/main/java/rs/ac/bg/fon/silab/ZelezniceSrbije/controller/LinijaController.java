package rs.ac.bg.fon.silab.ZelezniceSrbije.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Linija;
import rs.ac.bg.fon.silab.ZelezniceSrbije.service.LinijaService;

@RestController
@RequestMapping("/api/linija")
public class LinijaController {

	@Autowired
	private LinijaService linijaService;
	
	@GetMapping("/all")
	public List<Linija> findAll() {
		return this.linijaService.findAll();
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody Linija linija) {
		 this.linijaService.delete(linija.getLinijaID());	
	}
	
}
