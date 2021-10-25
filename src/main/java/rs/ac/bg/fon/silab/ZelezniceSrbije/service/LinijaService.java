package rs.ac.bg.fon.silab.ZelezniceSrbije.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Linija;
import rs.ac.bg.fon.silab.ZelezniceSrbije.repository.LinijaRepository;

@Service
@Transactional
public class LinijaService {

    @Autowired
    private LinijaRepository linijaRepository;

    public List<Linija> findAll() {
        System.out.println("getAllLinija");
        return linijaRepository.findAll();
    }

    public void delete(Linija linija) {
        linijaRepository.delete(linija);
    }

    public Linija add(Linija linija) {
        return linijaRepository.saveAndFlush(linija);
    }

}
