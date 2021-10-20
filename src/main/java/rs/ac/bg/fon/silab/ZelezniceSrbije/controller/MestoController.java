package rs.ac.bg.fon.silab.ZelezniceSrbije.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Mesto;
import rs.ac.bg.fon.silab.ZelezniceSrbije.service.MestoService;

@RestController
@RequestMapping("/api/mesto")
public class MestoController {
	
	@Autowired
	private MestoService mestoService;
	
	
	@GetMapping("/all")
	public List<Mesto> getAllMesto() {
		return this.mestoService.getAllMesto();
	}
}
