package rs.ac.bg.fon.silab.ZelezniceSrbije.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.silab.ZelezniceSrbije.service.MedjustanicaService;
import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Medjustanica;
import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.compositeKey.MedjustanicaCompositeKey;
@RestController
@RequestMapping("/api/medjustanica")
public class MedjustanicaController {

	@Autowired
	private MedjustanicaService medjustanicaService;
	
	@GetMapping("/linija/{linijaid}")
	public List<Medjustanica> getMedjustaniceByLinijaID(@PathVariable("linijaid") int linijaid){
		return medjustanicaService.getMedjustaniceByLinijaID(linijaid);
	} 
}
