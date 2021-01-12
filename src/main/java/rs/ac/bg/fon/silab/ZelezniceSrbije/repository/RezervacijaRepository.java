package rs.ac.bg.fon.silab.ZelezniceSrbije.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Rezervacija;

@Repository
public interface RezervacijaRepository extends JpaRepository<Rezervacija, Integer>{
	
	@Query(value = "select * from rezervacija where klijentid = :klijentid", nativeQuery = true)
	List<Rezervacija> getRezervacijeByUserID(@Param("klijentid") int klijentid);
	
}
