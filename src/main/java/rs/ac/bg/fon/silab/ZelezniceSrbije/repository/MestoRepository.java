package rs.ac.bg.fon.silab.ZelezniceSrbije.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Mesto;

@Repository
public interface MestoRepository extends JpaRepository<Mesto, Integer> {

	@Query(value = "select * from mesto", nativeQuery = true)
	List<Mesto> findAll();


}
