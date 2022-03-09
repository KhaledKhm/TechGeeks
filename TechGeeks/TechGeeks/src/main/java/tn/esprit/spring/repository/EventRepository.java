package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entities.*;



public interface EventRepository extends JpaRepository<Event,Integer> {
	@Query(value= "Select count(*) FROM event_event_users e WHERE e.event_id_event=:idEvent", nativeQuery = true) 
	int eventParticipants(@Param("idEvent") int idEvent);
	@Query(value= "Select count(*) FROM event_event_users e INNER JOIN User ON e.event_users_id_user = User.id_user WHERE e.event_users_id_user=:idUser", nativeQuery = true)
	int mostParticipatingUser(@Param("idUser") int idUser);
/*	@Query(value= "Select * FROM User u "
			+ "INNER JOIN event_event_users e ON e.event_users_id_user=u.id_user "
			+ "ORDER BY (Select count(e.event_users_id_user) FROM event_event_users "
			+ "WHERE e.event_users_id_user=u.id_user) DESC", nativeQuery = true) */
//	@Query(value ="SELECT * , COUNT(pl.nb_like)AS nombre_like FROM post p JOIN post_like pl ON p.id_post = pl.post_likes_id_post  where id=id_post GROUP BY p.id_post ORDER BY COUNT(pl.nb_like) DESC",nativeQuery = true)
	
}
