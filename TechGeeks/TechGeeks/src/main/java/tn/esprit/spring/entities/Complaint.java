package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Optional;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
public class Complaint implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idComplaint;
	
	private String title;
	private String response;
	
	@Enumerated(EnumType.STRING)
	private Type type;
	private String description;
	
	@ManyToOne
	@JsonIgnore
	private User userComplaint;
	@ManyToOne
	@JsonIgnore
	private User exper;
}
