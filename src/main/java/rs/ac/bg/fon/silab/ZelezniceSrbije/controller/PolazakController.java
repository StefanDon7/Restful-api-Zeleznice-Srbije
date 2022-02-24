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

import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Polazak;
import rs.ac.bg.fon.silab.ZelezniceSrbije.service.PolazakService;

@RestController
@RequestMapping("/api/polazak")
public class PolazakController {

    @Autowired
    private PolazakService polazakService;

    @GetMapping("/all")
    public List<Polazak> getAll() {
        return this.polazakService.getAll();
    }

    @GetMapping("/reservation/{polazakID}")
    public Polazak getNumberOfReservation(@PathVariable("polazakID") int polazakID) {
       return new Polazak(this.polazakService.getNumberOfReservation(polazakID));
    }
    
    @GetMapping("/{datum}")
    public List<Polazak> getAllByDate(@PathVariable("datum") String datum) {
        return this.polazakService.getAllByDate(datum);
    }

    @GetMapping("/{stanicaPocetna}/{stanicaKrajnja}/{datum}")
    public List<Polazak> getAllByDateStartAndFinalStation(@PathVariable("datum") String datum, @PathVariable("stanicaPocetna") String stanicaPocetna, @PathVariable("stanicaKrajnja") String stanicaKrajnja) {
        return this.polazakService.getAllByDateStartAndFinalStation(datum, stanicaPocetna, stanicaKrajnja);
    }
    
    @PostMapping("/add")
    public Polazak add(@RequestBody Polazak polazak) {
        return this.polazakService.add(polazak);
    }
    @PutMapping("/update")
    public int update(@RequestBody Polazak polazak) {
        return this.polazakService.update(polazak);
    }
    @DeleteMapping("/delete")
    public void delete(@RequestBody Polazak polazak) {
         this.polazakService.delete(polazak);
    }
    
    

}
