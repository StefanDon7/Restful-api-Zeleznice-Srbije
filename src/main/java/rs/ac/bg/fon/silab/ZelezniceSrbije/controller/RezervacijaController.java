package rs.ac.bg.fon.silab.ZelezniceSrbije.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Klijent;
import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Rezervacija;
import rs.ac.bg.fon.silab.ZelezniceSrbije.service.RezervacijaService;

@RestController
@RequestMapping("/api/rezervacija")
public class RezervacijaController {

    @Autowired
    private RezervacijaService rezervacijaService;

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

    @DeleteMapping("/delete/{rezervacijaID}")
    public void delete(@PathVariable("rezervacijaID") int rezervacijaID) {
        rezervacijaService.delete(rezervacijaID);
    }

}
