package rs.ac.bg.fon.silab.ZelezniceSrbije.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.TipLinije;

@Repository
public interface TipLinijeRepository extends JpaRepository<TipLinije, Integer>{

	@Query(value = "select * from tipLinije", nativeQuery = true)
	List<TipLinije> findAll();
	
}
