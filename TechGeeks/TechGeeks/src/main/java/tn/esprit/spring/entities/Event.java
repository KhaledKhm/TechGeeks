package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@SuppressWarnings("serial")
@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PUBLIC)
public class Event implements Serializable{

	public Event() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idEvent;
	
	private String libelle;
	
	@Temporal(TemporalType.DATE)
	private Date dateStart;
	
	@Temporal(TemporalType.DATE)
	private Date dateEnd;
	
	@JsonIgnore
	private Local local;
	

	
	

}
