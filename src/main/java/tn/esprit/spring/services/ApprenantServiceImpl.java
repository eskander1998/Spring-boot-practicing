package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.DAO.Apprenant;
import tn.esprit.spring.repository.ApprenantRepository;
@Slf4j
@Service()
public class ApprenantServiceImpl  implements IApprenantService{
	
	@Autowired
	ApprenantRepository ApprenantRepository;
	
	@Override
	public void ajouterApprenant(Apprenant Apprenant) {
		 ApprenantRepository.save(Apprenant);
	}

	
	/*
	@Autowired
	DataCenterRepository DataCenterRepository;
	@Autowired
	VirtualMachineRepository VirtualMachineRepository;
	*/
	
}
