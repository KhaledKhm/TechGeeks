package tn.esprit.spring.entities;



import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
	private Set<Donation> donations;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Event> events;
	
	
	@OneToMany
	private Set<Offre> offres;
	

	@OneToMany
	private Set<Postulant> postulantUser;
	
	@OneToMany(mappedBy="userAdvertising")
	private Set<Advertising> advertisings;
	
	@OneToMany(mappedBy="userComplaint")
	private Set<Complaint> complaints;
	
	@OneToMany(mappedBy="userPost")
	private Set<Post> posts;
	
	@OneToOne(mappedBy="user")
	private PostComment postComment;
	
	@ManyToOne
	private Appointment appointment;
	
	@OneToMany(mappedBy="expert")
	private Set<Appointment> appointments;
	
	@ManyToOne
	private Local localUser;
	
	@ManyToOne
	private Chat chat;
	
	@ManyToOne
	private Certificate userCertificate;
}
