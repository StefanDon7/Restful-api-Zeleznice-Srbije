package rs.ac.bg.fon.silab.ZelezniceSrbije.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Voz;


@Repository
public interface VozRepository extends JpaRepository<Voz, Integer> {

	@Query(value = "select * from voz", nativeQuery = true)
	List<Voz> findAll();
	
}
