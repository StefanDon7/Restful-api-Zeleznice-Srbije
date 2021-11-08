package rs.ac.bg.fon.silab.ZelezniceSrbije.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Linija;
import rs.ac.bg.fon.silab.ZelezniceSrbije.repository.LinijaRepository;
import rs.ac.bg.fon.silab.ZelezniceSrbije.service.LinijaService;

@Service
@Transactional
public class LinijaServiceImpl implements LinijaService{

    @Autowired
    private LinijaRepository linijaRepository;

    @Override
    public List<Linija> findAll() {
        System.out.println("getAllLinija");
        return linijaRepository.findAll();
    }

    @Override
    public void delete(Linija linija) {
        linijaRepository.delete(linija);
    }

    @Override
    public Linija add(Linija linija) {
        return linijaRepository.saveAndFlush(linija);
    }

}
