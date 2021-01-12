package rs.ac.bg.fon.silab.ZelezniceSrbije.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Stanica;

@Repository
public interface StanicaRepository extends JpaRepository<Stanica, Integer>{
	
	@Query(value="select * from stanica order by nazivstanice asc", nativeQuery = true)
	List<Stanica> getAll();
}
