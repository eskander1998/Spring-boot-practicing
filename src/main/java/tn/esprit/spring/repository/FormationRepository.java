package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.DAO.Formation;




public interface FormationRepository extends CrudRepository<Formation, Long>{
	
	/*@Query("SELECT d FROM DataCenter d WHERE d.espaceLibreDisque= :espaceLibreVM")
	DataCenter DCAvecEspaceLibreSupVm(@Param("espaceLibreVM") Long espaceLibreVM);

	@Query("Select dc From DataCenter dc where dc.date > '2019-11-01'")
	List<DataCenter> listerDataCenter();
	*/
	@Query(value = "SELECT formation FROM Formation formation where formation.dateDebut>=:debut and formation.dateFin<=:fin")
	List<Formation> formationEntredeuxDate(@Param("debut")Date debut,@Param("fin")Date fin);

}
