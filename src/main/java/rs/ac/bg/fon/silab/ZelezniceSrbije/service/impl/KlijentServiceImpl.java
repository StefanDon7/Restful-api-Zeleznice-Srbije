package rs.ac.bg.fon.silab.ZelezniceSrbije.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Klijent;
import rs.ac.bg.fon.silab.ZelezniceSrbije.exception.RecordNotFoundException;
import rs.ac.bg.fon.silab.ZelezniceSrbije.repository.KlijentRepository;
import rs.ac.bg.fon.silab.ZelezniceSrbije.service.KlijentService;

@Service
@Transactional
public class KlijentServiceImpl implements KlijentService {

    @Autowired
    private KlijentRepository klijentRepository;

    @Override
    public List<Klijent> getAllKlijent() {
        System.out.println("getAllUsers");
        return klijentRepository.getAllKlijent();
    }

    @Override
    public Klijent getByEmailAndPassword(String email, String password) {
        System.out.println("get " + email + " " + password);
        Klijent klijent = klijentRepository.getByEmailAndPassword(email, password);
        if (klijent == null) {
            throw new RecordNotFoundException("Korisnik nije pronađen!");
        }
        return klijent;
    }

    @Override
    public Klijent getKlijentById(int id) {
        System.out.println("get " + id);
        Klijent klijent = klijentRepository.getKlijentById(id);
        if (klijent == null) {
            throw new RecordNotFoundException("Korisnik nije pronađen!");
        }
        return klijent;
    }

    @Override
    public Klijent addNewKlijent(Klijent klijent) {
        System.out.println("add new klijent: " + klijent);
        return klijentRepository.save(klijent);
    }

    @Override
    public String getKlijentByEmail(String email) {
        System.out.println("getKlijentByEmail");
        return klijentRepository.getKlijentByEmail(email);
    }

    @Override
    public int update(Klijent klijent) {
        System.out.println("Update klijent username i lozinka");
        return klijentRepository.update(klijent.getKorisnickoIme(), klijent.getLozinka(), klijent.getKlijentID());
    }

    @Override
    public int updatePassword(Klijent klijent) {
        System.out.println("Update klijent lozinka");
        return klijentRepository.updatePassword(klijent.getLozinka(), klijent.getKlijentID());
    }

    @Override
    public int updateUsername(Klijent klijent) {
        System.out.println("Update klijent username");
        return klijentRepository.updateUsername(klijent.getKorisnickoIme(), klijent.getKlijentID());
    }

}
