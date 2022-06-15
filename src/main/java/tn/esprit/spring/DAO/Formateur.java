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
@ToString
@EqualsAndHashCode
@Entity
public class Formateur {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")

	private Long id; 

	private String nom;

	private String prenom;
	
	private Long tarifHoraire;
	
	private String email;

  

	
	@OneToMany( cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy="formateur")
	private List<Formation> formations;


	
	
	 
	
}
