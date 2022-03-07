package tn.esprit.spring.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
public class Training implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idTraining;
	
	private String description;
	

	private Date dateStart;

	private Date dateEnd;
	
	private int NbrParticipant;
	
	private  int TotalParticipant;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	private Float prix;
	
	@ManyToOne
	private Sector sector;
	
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy="training")
	@JsonIgnore
	private Set<Document> documents;
	
	@ManyToOne
	@JsonIgnore
	private Local local;
	
	@OneToMany(mappedBy="training")
	@JsonIgnore
	private Set<Certificate> certificates;
	
	@OneToMany(mappedBy="training")
	@JsonIgnore
	private Set <TrainingFeedback> feedback;
	
	@OneToOne
	@JsonIgnore
	private Quiz quiz;
}
