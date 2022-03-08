package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
@Table(name = "advertising")
public class Advertising implements Serializable{

enum pub{vidéo ,image}


	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idAdvertising;
	@NotNull
	@Size(min=5, max=30)
	private String nompublicite;
	@NotNull
	private Date datedebut;
	@NotNull
	private Date datefin;
	@NotNull
	private int nombreinitialevus;
	@NotNull
	private int nombrefinalvus;
	@NotNull
	private float coutpublication; 
	@NotNull
	private pub typepub;
	
	
	@ManyToOne
	@JsonIgnore
	private User userAdvertising;
}
