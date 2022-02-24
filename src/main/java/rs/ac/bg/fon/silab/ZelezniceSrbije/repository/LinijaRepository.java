package rs.ac.bg.fon.silab.ZelezniceSrbije.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Linija;

@Repository
public interface LinijaRepository extends JpaRepository<Linija, Integer> {

	@Query(value = "select * from linija", nativeQuery = true)
        @Override
	List<Linija> findAll();
	
}
