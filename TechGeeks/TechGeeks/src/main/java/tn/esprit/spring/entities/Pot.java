package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
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
public class Pot implements Serializable{


	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idPot;

	private String libelle;
	
	private float sum;
	
	@Column(length=8/*, message="bank account should only have 8 numbers"*/)
	private String bankAccount;
	
//	@JsonIgnore
//	@OneToOne
//	private Event event;
	
	@JsonIgnore
	@OneToMany
	private Set<Donation> donations;
	
}
