package tn.esprit.spring.DAO;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Formation {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")

	private Long id; 

	private String titre;
	

	@Enumerated (EnumType.STRING)
	private Niveau niveau;
	
	@Temporal(TemporalType.DATE)
	private Date dateDebut; 
	
	@Temporal(TemporalType.DATE)
	private Date dateFin; 
	
	private Long nbrHeures; 
	
	private Long nbrMaxParticipant;
	
	private Long frais; 
	
	@JsonIgnore
	@ManyToMany( cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	Set <Apprenant> apprenants;
	
	@JsonIgnore
	@ManyToOne (cascade = CascadeType.ALL)
		Formateur formateur;


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateDebut == null) ? 0 : dateDebut.hashCode());
		result = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());
		result = prime * result + ((frais == null) ? 0 : frais.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nbrHeures == null) ? 0 : nbrHeures.hashCode());
		result = prime * result + ((nbrMaxParticipant == null) ? 0 : nbrMaxParticipant.hashCode());
		result = prime * result + ((niveau == null) ? 0 : niveau.hashCode());
		result = prime * result + ((titre == null) ? 0 : titre.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Formation other = (Formation) obj;
		
		if (dateDebut == null) {
			if (other.dateDebut != null)
				return false;
		} else if (!dateDebut.equals(other.dateDebut))
			return false;
		if (dateFin == null) {
			if (other.dateFin != null)
				return false;
		} else if (!dateFin.equals(other.dateFin))
			return false;
		if (frais == null) {
			if (other.frais != null)
				return false;
		} else if (!frais.equals(other.frais))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nbrHeures == null) {
			if (other.nbrHeures != null)
				return false;
		} else if (!nbrHeures.equals(other.nbrHeures))
			return false;
		if (nbrMaxParticipant == null) {
			if (other.nbrMaxParticipant != null)
				return false;
		} else if (!nbrMaxParticipant.equals(other.nbrMaxParticipant))
			return false;
		if (niveau != other.niveau)
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		return true;
	}


	
    
}
