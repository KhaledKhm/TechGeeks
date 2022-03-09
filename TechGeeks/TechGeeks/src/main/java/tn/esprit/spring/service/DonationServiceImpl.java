//package tn.esprit.spring.service;
//
//import org.springframework.stereotype.Service;
//
//
//import lombok.extern.slf4j.Slf4j;
//import tn.esprit.spring.entities.Donation;
//import tn.esprit.spring.entities.Pot;
//import tn.esprit.spring.entities.User;
//import tn.esprit.spring.repository.DonationRepository;
//import tn.esprit.spring.repository.PotRepository;
//import tn.esprit.spring.repository.UserRepository;
//
//@Service
//public class DonationServiceImpl implements IDonationService{
//
//	public DonationServiceImpl() {
//		// TODO Auto-generated constructor stub
//	}
//
//	
//	@Autowired
//	DonationRepository donationRepository;
//	@Autowired
//	PotRepository potRepository;
//	@Autowired
//	UserRepository userRepository;
//	@Autowired
//	UserService userService;
//
//	@Override
//	public List<Donation> retrieveAllDonations() {
//		List<Donation> donationList = donationRepository.findAll();
//		for (Donation donation : donationList){
//			log.info(" Donation: " +donation);
//		}
//		return donationList;
//		
//	}
//
//	@Override
//	public Donation addDonation(Donation d) {
//		donationRepository.save(d);
//		return d;
//	}
//	
//	
//	
//
//	@Override
//	public Donation updateDonation(Donation d) {
//		donationRepository.save(d);
//		return d;
//	}
//
//	@Override
//	public Donation retrieveDonation(int id) {
//		return donationRepository.findById(id).orElse(null);
//	}
//
//	@Override
//	public void deleteDonation(int id) {
//		donationRepository.deleteById(id);
//		
//	}
//
//
//
//	@Override
//	@Transactional
//	public void addAndAssignPotAndUser(Donation donation, int idPot, int idUser) {
//		Pot p = potRepository.findById(idPot).orElse(null);	
//		User u = userRepository.findById(idUser).orElse(null);	
//		
//		p.setSum(p.getSum()+donation.getSum());
//		donation.setPot(p);
//		donation.setUser(u);
//				
//		donationRepository.save(donation);
//		
//	}
//
//	@Override
//	@Scheduled(cron = "* * * 1 * *")
//	public void numberDonationsByUser() {
//		for(Donation donation:retrieveAllDonations()){		
//		log.info("--- User: "
//				+ " First Name: "
//				+ donation.getUser().getFirstName()
//				+ " Last Name: " 
//				+ donation.getUser().getLastName()
//				+ " has made a total of "
//				+ donationRepository.nbreByUser(donation.getUser().getIdUser())
//				+ " donations ---" );
//		
//		}
//		
//	}
//	
//	
//	@Override
//	@Transactional
//	public Donation addDonationAndAssignPot(Donation d, int idPot) {
//		Pot p=potRepository.findById(idPot).orElse(null);
//		d.setPot(p);
//		donationRepository.save(d);
//		return d;
//		
//	}
//
//	@Override
//	public void donatedMoneyByPerson(int idUser) {
//		float sum=0;
////		List<User> users = userService.retrieveAllUsers();
//		List<Donation> donations = donationRepository.findByUserDonations(idUser);
//		for (int i = 0; i<donations.size();i++){
//			sum+=donations.get(i).getSum();	
//			log.info(""+donations.get(i).getUser().getUsername()+" donated a sum of "+sum );
//	}
//	
//	}
//
//	
//
//}
