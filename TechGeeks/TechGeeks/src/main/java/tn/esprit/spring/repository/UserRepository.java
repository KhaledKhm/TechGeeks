package tn.esprit.spring.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Query;
import tn.esprit.spring.entities.User;
@Repository
public interface UserRepository extends CrudRepository<User, Integer>{ 
	
    User findByUsername(String username);
    User findByEmail(String email);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    @Query(value ="SELECT * FROM User u JOIN event_event_users e ON e.event_users_id_user = u.id_user GROUP BY e.event_users_id_user ORDER BY e.event_users_id_user DESC",nativeQuery = true)
    List<User> sortMostParticipatingUsers();
}


