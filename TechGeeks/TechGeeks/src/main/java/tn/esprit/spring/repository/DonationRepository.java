//package tn.esprit.spring.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import tn.esprit.spring.entities.Donation;
//
//public interface DonationRepository extends JpaRepository<Donation,Integer>{
//
//
//	@Query("Select COUNT(*) FROM Donation d where d.user.idUser = :id")
//	int nbreByUser(@Param("id") int id);
//	float findByUserDonationsSum(int idUser);
//	List<Donation> findByUserDonations(int idUseR);
//}
