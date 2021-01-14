package rs.ac.bg.fon.silab.ZelezniceSrbije.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import rs.ac.bg.fon.silab.ZelezniceSrbije.domen.Polazak;

@Repository
public interface PolazakRepository extends JpaRepository<Polazak, Integer>{

	@Query(value = "select * from polazak", nativeQuery = true)
	List<Polazak> getAll();
	
	@Query(value = "select * from polazak where datumPolaska LIKE ?%", nativeQuery = true)
	List<Polazak> getAllByDate(String datum);
	
	@Query(value="SELECT * "
			+ "FROM polazak "
			+ "WHERE (linijaid IN(SELECT linijaid "
							  + "FROM Linija "
							  + "WHERE StanicaIDPolazna=(SELECT stanicaid "
							  						  + "FROM stanica "
							  						  + "WHERE nazivstanice=?2) AND "
							  		+ "StanicaIDKrajnja=(SELECT stanicaid "
							  						  + "FROM stanica "
							  						  + "WHERE nazivstanice=?3)) "
			+ "OR "
			+"linijaid IN(SELECT m1.linijaid "
						+ "FROM medjustanica m1 LEFT JOIN linija l ON (m1.linijaid=l.linijaid) "
						+ "WHERE l.StanicaIDPolazna=(SELECT stanicaid "
													+ "FROM stanica "
													+ "WHERE nazivstanice=?2)"
						+ "AND m1.stanicaid= (SELECT stanicaid "
											+ "FROM stanica "
											+ "WHERE nazivstanice=?3)) "
			+ "OR "
			+"linijaid IN(SELECT m1.linijaid "
						+ "FROM medjustanica m1 LEFT JOIN linija l ON (m1.linijaid=l.linijaid) "
						+ "WHERE l.StanicaIDKrajnja=(SELECT stanicaid "
													+ "FROM stanica "
													+ "WHERE nazivstanice=?3)"
						+ "AND m1.stanicaid= (SELECT stanicaid "
											+ "FROM stanica "
											+ "WHERE nazivstanice=?2)) "
			+"OR "
			+ "linijaid IN(SELECT m1.linijaid "
						+ "FROM medjustanica m1 LEFT JOIN medjustanica m2 ON (m1.linijaid=m2.linijaid) "
						+ "WHERE m1.stanicaid!=m2.stanicaid AND m1.rednibroj<m2.rednibroj AND "
						+ "m1.stanicaid=(SELECT stanicaid FROM stanica WHERE nazivstanice=?2) AND "
						+ "m2.stanicaid=(SELECT stanicaid FROM stanica WHERE nazivstanice=?3))) AND "
			+ "datumpolaska LIKE ?1%", 
			nativeQuery = true)
	List<Polazak> getAllByDateStartAndFinalStation(String datum, String stanicaPocetna, String stanicaKrajnja);
}	
