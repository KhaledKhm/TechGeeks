package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Optional;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class Complaint implements Serializable{

	public Complaint() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idComplaint;
	
	private String title;
	
	@Enumerated(EnumType.STRING)
	private Type type;
	private String description;
	
	@ManyToOne
	@JsonIgnore
	private User userComplaint;
}
