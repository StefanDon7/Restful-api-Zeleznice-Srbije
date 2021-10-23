package rs.ac.bg.fon.silab.ZelezniceSrbije.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Klijent;
import rs.ac.bg.fon.silab.ZelezniceSrbije.service.KlijentService;

@RestController
@RequestMapping("/api/klijent")
public class KlijentController {

    @Autowired
    private KlijentService klijentService;

    @GetMapping("/all")
    public List<Klijent> getAllKlijent() {
        return this.klijentService.getAllKlijent();
    }

    @PostMapping("/get")
    public ResponseEntity<Klijent> getKlijentByEmailAndPassword(@Valid @RequestBody Klijent klijent) {
        Klijent k = this.klijentService.getByEmailAndPassword(klijent.getEmail(), klijent.getLozinka());
        return new ResponseEntity<Klijent>(k, HttpStatus.OK);
    }

    @PostMapping("/getbyid")
    public Klijent getKlijentById(@RequestBody Klijent klijent) {
        return this.klijentService.getKlijentById(klijent.getKlijentID());
    }

    @PostMapping("/add")
    public ResponseEntity<Klijent> addNewKlijent(@Valid @RequestBody Klijent klijent, BindingResult errors) {
        Klijent k = this.klijentService.addNewKlijent(klijent);
        return new ResponseEntity<Klijent>(k, HttpStatus.OK);
    }

    @PostMapping("/getbyemail")
    public Klijent getKlijentByEmail(@RequestBody Klijent klijent) {
        String email = klijentService.getKlijentByEmail(klijent.getEmail());
        return new Klijent(-1, "", email, "", "", "");
    }
    
     @PutMapping("/update")
    public int update(@RequestBody Klijent klijent) {
        return this.klijentService.update(klijent);
    }

    @PutMapping("/updateusername")
    public int updateUsername(@RequestBody Klijent klijent) {
        return this.klijentService.updateUsername(klijent);
    }

    @PutMapping("/updatepassword")
    public int updatePassword(@RequestBody Klijent klijent) {
        return this.klijentService.updatePassword(klijent);
    }

}
