package rs.ac.bg.fon.silab.ZelezniceSrbije.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Rezervacija;

@Repository
public interface RezervacijaRepository extends JpaRepository<Rezervacija, Integer>{
	
	@Query(value = "select * from rezervacija where klijentid = :klijentid order by date desc", nativeQuery = true)
	List<Rezervacija> getRezervacijeByUserID(@Param("klijentid") int klijentid);

	@Query(value="INSERT INTO rezervacija VALUE(?1,?2,?3)", nativeQuery = true)
	Rezervacija sacuvajRezervaciju(int klijentID, int polazakID, Date date);

	@Query(value = "select * from rezervacija where klijentid=?1 and polazakid=?2", nativeQuery = true)
	Rezervacija getRezervacija(int klijentID, int polazakID);
	
}
