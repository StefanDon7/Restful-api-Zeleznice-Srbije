package rs.ac.bg.fon.silab.ZelezniceSrbije.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Rezervacija;
import rs.ac.bg.fon.silab.ZelezniceSrbije.repository.RezervacijaRepository;
import rs.ac.bg.fon.silab.ZelezniceSrbije.service.RezervacijaService;

@Service
@Transactional
public class RezervacijaServiceImpl implements RezervacijaService{

    @Autowired
    private RezervacijaRepository rezervacijaRepository;

    @Override
    public List<Rezervacija> getRezervacijeByUserID(int klijentid) {
        return this.rezervacijaRepository.getRezervacijeByUserID(klijentid);
    }

    @Override
    public void addRezervacija(Rezervacija rezervacija) {
        this.rezervacijaRepository.save(rezervacija);
    }

    @Override
    public Rezervacija getRezervacije(Rezervacija rezervacija) {
        return this.rezervacijaRepository.getRezervacija(rezervacija.getKlijent().getKlijentID(), rezervacija.getPolazak().getPolazakID());
    }

    @Override
    public void delete(Rezervacija rezervacija) {
        this.rezervacijaRepository.delete(rezervacija);
    }
}
