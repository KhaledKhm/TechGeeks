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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PUBLIC)
public class Post implements Serializable{

	public Post() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idPost;
	
	private String title;
	
	private String body;
	
	private String photo;
	
	private Date createdAt;
	
	@ManyToOne
	@JsonIgnore
	private User userPost;
	
	@OneToMany(mappedBy="post")
	@JsonIgnore
	private Set<PostComment> postComments;
	
	@OneToMany(mappedBy="post")
	@JsonIgnore
	private Set<PostLike> postLikes;
}
