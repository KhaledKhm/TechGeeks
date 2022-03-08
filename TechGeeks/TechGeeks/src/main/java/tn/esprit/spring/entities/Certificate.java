package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PUBLIC)
public class Certificate implements Serializable{

	public Certificate() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idCertificate;
	
	private String title;
	
	private String description;
	
	private Punishment punishment;
	
	@OneToOne
	private Quiz quiz;
	
	@OneToMany(mappedBy="certificate")
	private Set<Training> trainings;
	
	@OneToMany(mappedBy="userCertificate")
	private Set<User> users;

}
