package rs.ac.bg.fon.silab.ZelezniceSrbije.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Klijent;
import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Rezervacija;
import rs.ac.bg.fon.silab.ZelezniceSrbije.service.impl.RezervacijaServiceImpl;

@RestController
@RequestMapping("/api/rezervacija")
public class RezervacijaController {

    @Autowired
    private RezervacijaServiceImpl rezervacijaService;

    @PostMapping("/klijent/all")
    public List<Rezervacija> getRezervacijeByUserID(@RequestBody Klijent klijent) {
        return rezervacijaService.getRezervacijeByUserID(klijent.getKlijentID());
    }

    @PostMapping("/get")
    public Rezervacija getRezervacija(@RequestBody Rezervacija rezervacija) {
        return rezervacijaService.getRezervacije(rezervacija);
    }

    @PostMapping("/add")
    public void addRezervacija(@RequestBody Rezervacija rezervacija) {
        rezervacija.setDate(new Date());
        rezervacijaService.addRezervacija(rezervacija);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Rezervacija rezervacija) {
        rezervacijaService.delete(rezervacija);
    }

}
