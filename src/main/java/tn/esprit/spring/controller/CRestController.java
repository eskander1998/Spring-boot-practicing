package tn.esprit.spring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.DAO.Apprenant;
import tn.esprit.spring.DAO.Formateur;
import tn.esprit.spring.DAO.Formation;
import tn.esprit.spring.services.IApprenantService;
import tn.esprit.spring.services.IFormateurService;
import tn.esprit.spring.services.IFormationService;



@RestController
public class CRestController {

	
	  @Autowired
	  IFormationService IFormationService;
	  @Autowired
	  IFormateurService IFormateurService;
	  @Autowired
	  IApprenantService IApprenantService;
	  
	  @PostMapping("/add-formateur")
			@ResponseBody
			public void ajouterformateur(@RequestBody Formateur u) {
		  IFormateurService.ajouterFormateur(u);;
			}
	  
	  @PostMapping("/add-apprenant")
		@ResponseBody
		public void ajouterapprenant(@RequestBody Apprenant u) {
		  IApprenantService.ajouterApprenant(u);
		}
	  
	  @PostMapping("/ajouteretaffecterFormationAFormateur")
		@ResponseBody
	  public void ajouteretaffecterFormationAFormateur(@RequestBody Formation fo,@RequestParam(value="formateur") Formateur f){
		  
		  IFormationService.ajouteretaffecterFormationAFormateur(fo, f);  
	  }
	  
	  @PostMapping("/affecterApprenantFormation")
		@ResponseBody
	  public void affecterApprenantFormation( @RequestParam(value="idApprenant") Long idApprenant,@RequestParam(value="idFormation") Long idFormation){
		  
		  IFormationService.affecterApprenantFormation(idApprenant, idFormation);  
	  }
	  
	 /* 
	  @GetMapping("/renum/{idFormateur}/{debut}/{fin}")
		public float calculerRenumFormateur(@PathVariable("idFormateur") Long idFormateur,@PathVariable("debut") @DateTimeFormat(pattern="yyyy-MM-dd") Date debut, @PathVariable("fin") @DateTimeFormat(pattern="yyyy-MM-dd")Date fin) {
		  
		  
			return calculerRenumFormateur( idFormateur,  debut,  fin);
	  
	  }
	  */

	  @GetMapping("/renum/{idFormateur}/{debut}/{fin}")
		@ResponseBody
		public float calculerRenumFormateur(@PathVariable("idFormateur") Long idFormateur,@PathVariable("debut") @DateTimeFormat(pattern="yyyy-MM-dd") Date debut, @PathVariable("fin") @DateTimeFormat(pattern="yyyy-MM-dd")Date fin) {
		  
		  
			return IFormationService.calculerRenumFormateur( idFormateur,  debut,  fin);
	  
	  }
	  
	  @GetMapping("/renumFormation/{idFormation}")
		@ResponseBody
		public float calculerRenumFormateur(@PathVariable("idFormation") Long idFormation) {
		  
		  
			return IFormationService.getRevenuebyFormation(idFormation);
	  
	  }
}
