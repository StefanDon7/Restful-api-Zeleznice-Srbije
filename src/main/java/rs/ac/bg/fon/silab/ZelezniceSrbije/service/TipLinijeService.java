package rs.ac.bg.fon.silab.ZelezniceSrbije.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.TipLinije;
import rs.ac.bg.fon.silab.ZelezniceSrbije.repository.TipLinijeRepository;

@Service
@Transactional
public class TipLinijeService {

	@Autowired
	private TipLinijeRepository tipLinijeRepository;
	
	public List<TipLinije> getAllTipLinije() {
		System.out.println("getAllTipLinije");
		return tipLinijeRepository.findAll();
	}
}
