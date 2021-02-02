package rs.ac.bg.fon.silab.ZelezniceSrbije.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Klijent;

@Repository
public interface KlijentRepository extends JpaRepository<Klijent, Integer>{
	
	@Query(value = "select * from klijent", nativeQuery = true)
	List<Klijent> getAllKlijent();
	
	@Query(value ="select * from Klijent where email=?1 and lozinka=?2", nativeQuery = true)
	Klijent getByEmailAndPassword(String email,String password);

	@Query(value ="select * from Klijent where klijentid=?", nativeQuery = true)
	Klijent getKlijentById(int id);
	
	@Query(value ="select email from Klijent where email=?1", nativeQuery = true)
	String getKlijentByEmail(String email);
	
    @Modifying
	@Query(value ="update klijent set KorisnickoIme = ?1  where klijentid=?2", nativeQuery = true)
	int updateUsername(String korisnickoIme,int id);
    
    @Modifying
	@Query(value ="update klijent set lozinka = ?1 where klijentid=?2", nativeQuery = true)
	int updatePassword(String lozinka,int id);
	
	
}
