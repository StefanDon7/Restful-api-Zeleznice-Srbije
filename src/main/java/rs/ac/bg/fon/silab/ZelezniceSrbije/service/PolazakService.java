/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.ZelezniceSrbije.service;

import java.util.List;
import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Polazak;

/**
 *
 * @author Stefan
 */
public interface PolazakService {

    List<Polazak> getAll();

    List<Polazak> getAllByDate(String datum);

    List<Polazak> getAllByDateStartAndFinalStation(String datum, String stanicaPocetna, String stanicaKrajnja);

    int getNumberOfReservation(int polazakID);

    Polazak add(Polazak polazak);

    int update(Polazak polazak);

    void delete(Polazak polazak);

}
