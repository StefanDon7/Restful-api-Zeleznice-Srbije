package rs.ac.bg.fon.silab.ZelezniceSrbije.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.TipLinije;
import rs.ac.bg.fon.silab.ZelezniceSrbije.service.TipLinijeService;
import rs.ac.bg.fon.silab.ZelezniceSrbije.service.impl.TipLinijeServiceImpl;

@RestController
@RequestMapping("/api/tipLinije")
public class TipLinijeController {

	@Autowired
	private TipLinijeService tipLinijeService;
	
	@GetMapping("/all")
	public List<TipLinije> getAllTipLinije() {
		return this.tipLinijeService.getAllTipLinije();
	}
}
