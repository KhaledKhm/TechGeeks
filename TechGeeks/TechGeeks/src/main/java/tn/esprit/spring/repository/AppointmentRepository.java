package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Appointment;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

	@Query("Select distinct a FROM Appointment a ,User u where a.expert.id=:id")
	List <Appointment> findAppointmentByUser(@Param("id") int iduser);
	@Query(value="SELECT * FROM `appointment` WHERE expert_id AND women_id IS NOT NULL",nativeQuery=true)
	List <Appointment>  verifuser();
	@Query(value="SELECT expert_id FROM appointment a WHERE a.expert_id IS NOT NULL",nativeQuery=true)
	int iduser();
	
}
