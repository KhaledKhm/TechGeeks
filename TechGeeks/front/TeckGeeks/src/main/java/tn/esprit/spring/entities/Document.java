package tn.esprit.spring.entities;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import tn.esprit.spring.entities.Training;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class Document implements Serializable{
	
	public Document( String fileName, String contentType, byte[] data) {
		this.fileName = fileName;
		this.contentType = contentType;
		this.data=data;
	}
	

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idDocument;

	private String description;
	private String fileName;
	private String contentType;
	
	@Lob
	private byte[] data;
	
	
	
	@ManyToOne
	@JsonIgnore
	private Training training;

}
