package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
public class Appointment implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idAppointment;
	
	private Date date;
	
	private String local;
	
	@OneToMany
	@JsonIgnore
	private Set<User> users;
	
	@ManyToOne
	@JsonIgnore
	private User expert;
}
