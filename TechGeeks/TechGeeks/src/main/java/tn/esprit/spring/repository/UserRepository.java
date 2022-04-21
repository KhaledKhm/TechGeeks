package tn.esprit.spring.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.spring.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{ 
	
    User findByUsername(String username);
    User findByEmail(String email);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    @Query(value ="SELECT * FROM User u JOIN event_event_users e ON e.event_users_id = u.id GROUP BY e.event_users_id ORDER BY COUNT(e.event_users_id) DESC",nativeQuery = true)
    List<User> sortMostParticipatingUsers();
}


