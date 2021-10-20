package rs.ac.bg.fon.silab.ZelezniceSrbije.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.silab.ZelezniceSrbije.service.MedjustanicaService;
import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Medjustanica;

@RestController
@RequestMapping("/api/medjustanica")
public class MedjustanicaController {

	@Autowired
	private MedjustanicaService medjustanicaService;
	
	@GetMapping("/all")
	public List<Medjustanica> getall() {
		return medjustanicaService.getAll();
	}

	@GetMapping("/{linijaid}")
	public List<Medjustanica> getMedjustaniceByLinijaID(@PathVariable("linijaid") int linijaid) {
		return medjustanicaService.getMedjustaniceByLinijaID(linijaid);
	}

	@PostMapping("/add")
	public Medjustanica add(@RequestBody Medjustanica medjustanica) {
		return medjustanicaService.add(medjustanica);
	}

	@PutMapping("/update")
	public int update(@RequestBody Medjustanica medjustanica) {
		return medjustanicaService.update(medjustanica);
	}
	
	@DeleteMapping("/delete")
	public int delete(@RequestBody Medjustanica medjustanica) {
		return medjustanicaService.delete(medjustanica);
	}
}
