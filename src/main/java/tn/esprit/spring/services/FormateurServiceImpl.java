package tn.esprit.spring.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import tn.esprit.spring.DAO.Formateur;



@Service
public class FormateurServiceImpl implements IFormateurService{

	
	@Autowired
	tn.esprit.spring.repository.FormateurRepository FormateurRepository;
	
	
	@Override
	public void ajouterFormateur(Formateur formateur) {
		FormateurRepository.save(formateur);		
	}

	/*
	
	@Autowired
	VirtualMachineRepository VirtualMachineRepository;
	@Autowired
	UtilisateurRepository UtilisateurRepository;
	@Autowired
	DataCenterRepository DataCenterRepository;
	*/
	
}
