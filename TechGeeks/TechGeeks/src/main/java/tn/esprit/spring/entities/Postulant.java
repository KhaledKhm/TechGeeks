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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class Postulant implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idPostulant;
	
	private Etat etat;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="postulantUser")
	@JsonIgnore
	private Set<User> users;
	
	@OneToMany
	@JsonIgnore
	private Set<Offre> offres;
	
	@OneToMany(mappedBy="postulantInterview")
	@JsonIgnore
	private Set<Interview> interviews;

}
