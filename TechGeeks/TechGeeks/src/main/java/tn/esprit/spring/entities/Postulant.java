package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PUBLIC)
public class Postulant implements Serializable{

	public Postulant() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idPostulant;
	
	private Etat etat;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="postulantUser")
	private Set<User> users;
	
	@OneToMany
	private Set<Offre> offres;
	
	@OneToMany(mappedBy="postulantInterview")
	private Set<Interview> interviews;

}
