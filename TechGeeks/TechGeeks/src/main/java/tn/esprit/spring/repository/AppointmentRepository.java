package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Appointment;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

	@Query("Select distinct a FROM Appointment a ,User u where a.expert.idUser=:id")
	List <Appointment> findAppointmentByUser(@Param("id") int iduser);
}
