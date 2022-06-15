package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.DAO.*;
@Repository
public interface ApprenantRepository extends JpaRepository<Apprenant, Long> {
/*
	List<VirtualMachine> findByBoutiquesId(Long id);

	List<VirtualMachine> findByBoutiquesCategorie(Categorie  cat);
*/
}
