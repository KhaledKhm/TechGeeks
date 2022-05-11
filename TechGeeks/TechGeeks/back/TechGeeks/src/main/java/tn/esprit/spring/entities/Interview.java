package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PUBLIC)
public class Interview implements Serializable{

	public Interview() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idInterview;
	
	private Date dateInterview;
	
	private Etat type;
	
	@ManyToOne
	@JsonIgnore
	private Postulant postulantInterview;
	
	

}
