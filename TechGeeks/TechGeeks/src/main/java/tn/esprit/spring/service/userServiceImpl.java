//package tn.esprit.spring.service;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
//import org.springframework.stereotype.Service;
//
//import lombok.extern.slf4j.Slf4j;
//import tn.esprit.spring.entities.Provider;
//import tn.esprit.spring.entities.Role;
//import tn.esprit.spring.entities.RoleName;
//import tn.esprit.spring.entities.User;
//import tn.esprit.spring.repository.RoleRepository;
//import tn.esprit.spring.repository.UserRepository;
//@Slf4j
//@Service
//public class userServiceImpl implements userService{
//	@Autowired
//	UserRepository userRepository;
//	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//	@Autowired
//	RoleRepository  roleRepository;
//	
//	@Override
//	public Set<User> retrieveAllUsers() {
//		Set<User> users = new HashSet<User>();
//		userRepository.findAll().forEach(users::add);
//		return users;
//	}
//
//	@Override
//	public User addUser(User user) {
//		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		user.setPassword(encoder.encode(user.getPassword()));
//		user.setActive(true);
//		return userRepository.save(user);
//	}
//
//	
//	
//
//	@Override
//	public User findUserByUserName(String userName) {
//		return userRepository.findByUserName(userName);
//	}
//	public User view(User userName) {
//		return userName ;
//	}
//
//	public  void processOAuthPostLogin(DefaultOidcUser username,User hamza,Set<Role> r) {
//		String usern = username.getAttribute("email");
//		System.out.println(""+username.getAttribute("email"));
//		System.out.println(""+hamza);
//        if (hamza == null){
//            User newUser = new User();
//            newUser.setUserName( username.getAttribute("name"));
//            newUser.setFirstName( username.getAttribute("given_name"));
//            newUser.setLastName(username.getAttribute("family_name"));
//            newUser.setEmail( username.getAttribute("email"));
//            newUser.setProvider(Provider.GOOGLE);
//            Set<Role> h=newUser.getRoles();
//            newUser.setRoles(r);
//            newUser.setActive(true);          
//            System.out.print(newUser.getRoles());
//            
//            userRepository.save(newUser);        
//        }
//	}
//
//	public User findUserByEmail(String email) {
//		// TODO Auto-generated method stub
//		return userRepository.findByEmail(email);
//	}
//
//
//
//
//	
//	
//
//}
