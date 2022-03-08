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
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import tn.esprit.spring.entities.Advertising.pub;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class PostComment implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idComment;
	
	private String comment;
	
	@JsonIgnore
	@OneToMany(mappedBy="postComment")
	private Set<CommentLike> commentLikes;
	@JsonIgnore
	@ManyToOne
	private Post post;
	@JsonIgnore
	@OneToOne
	private User user;
}
