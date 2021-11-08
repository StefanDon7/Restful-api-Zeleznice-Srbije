/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.ZelezniceSrbije.service;

import java.util.List;
import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Rezervacija;

/**
 *
 * @author Stefan
 */
public interface RezervacijaService {

    List<Rezervacija> getRezervacijeByUserID(int klijentid);

    void addRezervacija(Rezervacija rezervacija);

    Rezervacija getRezervacije(Rezervacija rezervacija);

    void delete(Rezervacija rezervacija);
;

}
