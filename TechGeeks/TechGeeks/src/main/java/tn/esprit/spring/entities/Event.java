package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@SuppressWarnings("serial")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class Event implements Serializable{


	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idEvent;
	
	private String libelle;
	
	@Temporal(TemporalType.DATE)
	private Date dateStart;
	
	@Temporal(TemporalType.DATE)
	private Date dateEnd;
	
	private float sum;

	private float price;

	@JsonIgnore
	@ManyToOne
	private Local localEvent;
	
	@JsonIgnore
	@ManyToMany
	private Set<User> eventUsers;
	
	

}
