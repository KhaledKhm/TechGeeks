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
public class Local implements Serializable{



	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idLocal;
	
	private String city;
	
	private String governorate;
	
	private int postalCode;
	
	private String address;
	
	private String name;
	
	
	@Temporal(TemporalType.DATE)
	private Date dateStart;
	
	@Temporal(TemporalType.DATE)
	private Date dateEnd;
	
	@JsonIgnore
	@OneToMany
	private Set<Event> events;
	
	@JsonIgnore
	@OneToMany(mappedBy="local")
	private Set<Training> trainings;
	
	@JsonIgnore
	@OneToMany(mappedBy="localUser")
	private Set<User> users;
}
