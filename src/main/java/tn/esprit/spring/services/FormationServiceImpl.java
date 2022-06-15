package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.DAO.Apprenant;
import tn.esprit.spring.DAO.Formateur;
import tn.esprit.spring.DAO.Formation;
import tn.esprit.spring.repository.ApprenantRepository;
import tn.esprit.spring.repository.FormationRepository;


@Slf4j
@Service()
public class FormationServiceImpl implements IFormationService{

	
	@Autowired
	FormationRepository FormationRepository;
	@Autowired
	tn.esprit.spring.repository.FormateurRepository FormateurRepository;	
	@Autowired
	ApprenantRepository ApprenantRepository;
	public void ajouteretaffecterFormationAFormateur(Formation formation, Formateur formateur){
		
		FormateurRepository.save(formateur);
		formation.setFormateur(formateur);
		FormationRepository.save(formation);
	}

	@Override
	public void affecterApprenantFormation(Long idApprenant, Long idFormation) {

		List<Formation> formations = (List<Formation>) FormationRepository.findAll();
		
		Apprenant apprenant = ApprenantRepository.findById(idApprenant).get();
		
		for(Formation f:formations)
		{
			if(f.getId()==idFormation&&f.getApprenants().size()<=f.getNbrMaxParticipant())
			{
				f.getApprenants().add(apprenant);
				FormationRepository.save(f);

			}
		}
		
	}
	
	//@Scheduled(cron="0/30 * * * * *")
	public void getNbrApprenantByFormation(){
		List<Formation> formations = (List<Formation>) FormationRepository.findAll();

		for(Formation f : formations)
		{
			log.info("La formations : "+f.getTitre() + " contient : "+ f.getApprenants().size() + " apprenants");

		}
		
	}

	@Override
	public float calculerRenumFormateur(Long idFormateur, Date debut, Date fin) {

		List<Formation> f=FormationRepository.formationEntredeuxDate(debut, fin);
		Formateur Formateur = FormateurRepository.findById(idFormateur).get();

		float renum=0;
		for(Formation fo: f)
		{
	
			if(fo.getFormateur().getId().equals(idFormateur))
			{
			System.out.println("aaaaaaaaaaa"+fo);
				renum=renum+(fo.getNbrHeures()*Formateur.getTarifHoraire());
			}
		}
		return renum;
	}

	@Override
	public float getRevenuebyFormation(Long Idforma) {
		Formation f = FormationRepository.findById(Idforma).get();
		
		float revenue=f.getApprenants().size()*f.getFrais();
		
		return revenue;
	}

	

}
