package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Donation;

@Repository
public interface DonationRepository extends JpaRepository<Donation,Integer>{

	@Query("Select COUNT(*) FROM Donation d where d.donationUser.id = :id")
	int nbreByUser(@Param("id") int id);
	//@Query("Select SUM(sum) FROM Donation d INNER JOIN User ON d.user.idUser = User.idUser")
	@Query(value= "Select SUM(sum) FROM Donation d INNER JOIN User ON d.donation_user_id = User.id WHERE d.donation_user_id = :idUser", nativeQuery = true) 
	float sumDonations(@Param("idUser") int idUser);
	//List<Donation> findByUserDonations(int idUseR);
}
