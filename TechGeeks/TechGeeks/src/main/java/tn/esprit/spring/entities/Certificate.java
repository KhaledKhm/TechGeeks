package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
public class Certificate implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idCertificate;
	
	private String title;
	
	private String description;
	
	private Punishment punishment;
	
	@OneToOne
	@JsonIgnore
	private Quiz quiz;
	
	@OneToMany(mappedBy="certificate")
	@JsonIgnore
	private Set<Training> trainings;
	
	@OneToMany(mappedBy="userCertificate")
	@JsonIgnore
	private Set<User> users;

}
