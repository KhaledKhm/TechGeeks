package tn.esprit.spring.entities;



import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private int id;

	private String username;
	
	private String Password;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String gender;
	
	private int num;
	
	private String city;
	
	private String governorate;
	
	private int postalCode;
	
	private String address;
	
	private String Vcode;
	
	private String photo; //a revoir
	private Boolean etat;
	@Enumerated(EnumType.STRING)
    private Provider provider;
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch= FetchType.EAGER)
	private Set<Role> roles;

	/**
	 * @param username
	 * @param password
	 * @param firstName
	 * @param email
	 */
	public User(String username, String password, String firstName, String email) {
		super();
		this.username = username;
		Password = password;
		this.firstName = firstName;
		this.email = email;
	}

	private ExpertRole expertRole;
		

	private String document;
	
//	@JsonIgnore
//	@OneToMany(mappedBy="donationUser")
//	private Set<Donation> donations;
	
//	@ManyToMany
//	private Set<Event> events;

	
	@OneToMany
	@JsonIgnore
	private Set<Offre> offres;

	@JsonIgnore
	@OneToMany(mappedBy="users")
	private Set<Postulant> postulants;

	
	@OneToMany(mappedBy="userAdvertising")
	@JsonIgnore
	private Set<Advertising> advertisings;
	
	@OneToMany(mappedBy="userComplaint")
	@JsonIgnore
	private Set<Complaint> complaints;
	@OneToMany(mappedBy="exper")
	@JsonIgnore
	private Set<Complaint> complaintss;
	@OneToMany(mappedBy="userPost")
	@JsonIgnore
	private Set<Post> posts;
	
	@OneToOne(mappedBy="user")
	@JsonIgnore
	private PostComment postComment;
	

	@OneToMany(mappedBy="women")
	@JsonIgnore
	private Set<Appointment> appointmentss;

	
	@OneToMany(mappedBy="expert")
	@JsonIgnore
	private Set<Appointment> appointments;
	
	@ManyToOne
	@JsonIgnore
	private Local localUser;
	
	@ManyToOne
	@JsonIgnore
	private Chat chat;
	
	@ManyToOne
	@JsonIgnore
	private Certificate userCertificate;
}
