package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.DAO.Formateur;
import tn.esprit.spring.DAO.Formation;

public interface IFormationService
{
	
public void ajouteretaffecterFormationAFormateur(Formation fo, Formateur f);


public void affecterApprenantFormation(Long idApprenant, Long idFormation);
public float calculerRenumFormateur(Long idFormateur,Date debut, Date fin);
public float getRevenuebyFormation(Long Idforma);
	}
