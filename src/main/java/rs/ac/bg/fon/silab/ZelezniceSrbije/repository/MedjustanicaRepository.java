package rs.ac.bg.fon.silab.ZelezniceSrbije.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Medjustanica;


@Repository
public interface MedjustanicaRepository  extends JpaRepository<Medjustanica, Integer> {

	@Query(value = "select * from medjustanica order by linijaid", nativeQuery = true)
	List<Medjustanica> getAll();
	
	@Query(value = "select * from medjustanica where linijaid = :linijaid order by rednibroj asc", nativeQuery = true)
	List<Medjustanica> getMedjustaniceByLinijaID(@Param("linijaid") int linijaID);
	
	@Modifying
	@Query(value ="UPDATE medjustanica SET rednibroj = :redniBroj WHERE linijaid = :linijaID AND stanicaid = :stanicaID", nativeQuery = true)
	int update(@Param("redniBroj") int redniBroj, @Param("linijaID")int linijaID, @Param("stanicaID")int stanicaID);

	@Modifying
	@Query(value ="delete from medjustanica where linijaid= :linijaID and stanicaid= :stanicaID", nativeQuery = true)
	int delete( @Param("linijaID")int linijaID, @Param("stanicaID")int stanicaID);

	

}
