package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
@FieldDefaults(level = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "advertising")
public class Advertising implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idAdvertising;
	@NotNull
	private String nameAd;
	@NotNull
	private Date dateStart;
	
	@NotNull
	private Date dateEnd;
	
	@NotNull
	private int numbervus;
	
	
	
	@NotNull
	private float price; 
	
	@NotNull
	private pub typepub;
	
	
	@ManyToOne
	@JsonIgnore
	private User userAdvertising;
	
	
}