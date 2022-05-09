package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
public class Donation implements Serializable{


	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idDonation;
	
	@Temporal(TemporalType.DATE)
	private Date dateDonation;
	
	private float sum;
	
	private String bankAccount;

	//@JsonIgnore
	@ManyToOne
	private Pot pot;
	
	@JsonIgnore
	@ManyToOne
	private User donationUser;
}
