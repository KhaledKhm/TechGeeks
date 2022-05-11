package tn.esprit.spring.entities;



import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PUBLIC)
public class User implements Serializable{

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idUser;

	private String login;
	
	private String pwd;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String gender;
	
	private int num;
	
	private String city;
	
	private String governorate;
	
	private int postalCode;
	
	private String address;
	
	private String photo; //a revoir
	
	@OneToMany
	private Set<Role> roles;

	private ExpertRole expertRole;
		
	private String document;
	
	@OneToMany
	@JsonIgnore
	private Set<Donation> donations;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Event> events;
	
	
	@OneToMany
	@JsonIgnore
	private Set<Offre> offres;
	
	@ManyToOne
	
	private Postulant postulantUser;
	
	@OneToMany(mappedBy="userAdvertising")
	
	private Set<Advertising> advertisings;
	
	@OneToMany(mappedBy="userComplaint")
	
	private Set<Complaint> complaints;
	@JsonIgnore
	@OneToMany(mappedBy="exper")
	private Set<Complaint> complaintss;
	@JsonIgnore
	@OneToMany(mappedBy="userPost")
	
	private Set<Post> posts;
	
	@OneToOne(mappedBy="user")
	
	private PostComment postComment;
	
	@OneToMany(mappedBy="women")
	
	private Set<Appointment> appointmentss;
	
	@OneToMany(mappedBy="expert")
	
	private Set<Appointment> appointments;
	
	@ManyToOne
	
	private Local localUser;
	
	@ManyToOne
	
	private Chat chat;
	
	@ManyToOne
	
	private Certificate userCertificate;
}
