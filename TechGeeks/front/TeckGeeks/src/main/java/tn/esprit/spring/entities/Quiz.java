package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
public class Quiz implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idQuiz;
	
	private String title;
	
	private double mark;
	
	private int time;
	

	@OneToMany(mappedBy="quiz")
	@JsonIgnore
	private Set<Question> questions;
	
	@OneToMany(mappedBy="quiz")
	@JsonIgnore
	private Set<Certificate> certificates;
	
	@OneToOne (mappedBy="quiz")
	@JsonIgnore
	private Training training;
	
	
}
