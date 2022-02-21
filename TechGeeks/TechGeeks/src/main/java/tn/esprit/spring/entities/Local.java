package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PUBLIC)
public class Local implements Serializable{

	public Local() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idLocal;
	
	private String city;
	
	private String governorate;
	
	private int postalCode;
	
	private String address;
	
	private String name;
	
	private int maxNumber;
	
	@Temporal(TemporalType.DATE)
	private Date dateStart;
	
	@Temporal(TemporalType.DATE)
	private Date dateEnd;
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Event> events;
	
	@JsonIgnore
	@OneToMany(mappedBy="local")
	private Set<Training> trainings;
	
	@JsonIgnore
	@OneToMany(mappedBy="localUser")
	private Set<User> users;
}
