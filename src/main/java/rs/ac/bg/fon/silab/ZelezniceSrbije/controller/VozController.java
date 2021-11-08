package rs.ac.bg.fon.silab.ZelezniceSrbije.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Voz;
import rs.ac.bg.fon.silab.ZelezniceSrbije.service.impl.VozServiceImpl;

@RestController
@RequestMapping("/api/voz")
public class VozController {

	
	@Autowired
	private VozServiceImpl vozService;
	
	
	@GetMapping("/all")
	public List<Voz> findAll() {
		return this.vozService.findAll();
	}
}
