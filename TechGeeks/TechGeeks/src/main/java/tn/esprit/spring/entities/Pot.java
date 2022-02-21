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
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PUBLIC)
public class Pot implements Serializable{

	public Pot() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idPot;

	private String libelle;
	
	private String bankAccount;
	
	@JsonIgnore
	@OneToOne
	private Event event;
	
	@JsonIgnore
	@OneToMany
	private Set<Donation> donations;
	
}
