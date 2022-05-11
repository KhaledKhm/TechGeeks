package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
//@FieldDefaults(level = AccessLevel.PUBLIC)
public class Post implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idPost;
	
	private String title;
	
	private String body;
	
	private String photo;
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	
	@JsonIgnore
	@ManyToOne
	private User userPost;
	@JsonIgnore 
	@OneToMany(mappedBy="post")
	private Set<PostComment> postComments;
	@JsonIgnore
	@OneToMany(mappedBy="post")
	private Set<PostLike> postLikes;
}
