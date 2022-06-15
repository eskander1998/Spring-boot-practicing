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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class Apprenant {
	
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column(name="id")

private Long id; 

private String nom;

private String prenom;

private Long telephone;

private String email;

@JsonIgnore
@ManyToMany( cascade = CascadeType.ALL,mappedBy = "apprenants",fetch = FetchType.EAGER)
Set <Formation> formations;



}
