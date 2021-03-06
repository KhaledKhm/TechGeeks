package tn.esprit.spring.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Certificate;
import tn.esprit.spring.entities.Provider;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.RoleName;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.mail.EmailControllers;
import tn.esprit.spring.payload.request.LoginRequest;
import tn.esprit.spring.payload.request.SignupRequest;
import tn.esprit.spring.payload.response.JwtResponse;
import tn.esprit.spring.payload.response.MessageResponse;
import tn.esprit.spring.repository.RoleRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.security.UserDetailsImpl;
import tn.esprit.spring.security.jwt.JwtUtils;
import tn.esprit.spring.service.ServiceUser;



//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@RequestMapping("/api/auth")
public class AuthController {
//  @Autowired
//  AuthenticationManager authenticationManager;

//  @Autowired
//  ServiceUser ServiceUser;
//  @Autowired
//  UserRepository userRepository;
  

//  @Autowired
//  RoleRepository roleRepository;

//  @Autowired
//	EmailControllers  EmailController;

 

 // @Autowired
 // JwtUtils jwtUtils;
  
//	@Autowired
//	IUserService userservice;
	
/*	@PostMapping("/AffecterCertificate/{idUser}/{certficates}")
	public void AffecterCertificate(@RequestBody User user,@PathVariable("idUser") int idUser,@PathVariable("certficates") List<Certificate> certficates) {
		ServiceUser.AffecterCertificat(idUser,certficates);
	}

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
	  User u = userRepository.findByEmail(loginRequest.getEmail());
	  if( u.getProvider().toString() != "LOCAL" ){
		  return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Your should connect with your "+u.getProvider());
	  }else if(u.getEtat() == false ){
		  return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Your should Verifie your account  ");
	  }
		  
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(u.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());
    
    
    return ResponseEntity.ok(new JwtResponse(jwt, 
                         userDetails.getId(), 
                         userDetails.getUsername(), 
                         userDetails.getEmail(), 
                         roles));
   
  }

  @PostMapping("/signup")
  public String registerUser( @RequestBody User signUpRequest) throws MessagingException  {
			Set<Role> Role = new HashSet();
		String msg="";
	User userExists = userRepository.findByUsername(signUpRequest.getUsername());
		if (userExists != null) {
			msg="There is already a user registered with the user name provided";
		} else {
			Set<Role> roles = signUpRequest.getRoles();
			for (Role role : roles) {
	          
	         Role r= roleRepository.findByRole(role.getRole());
	         if(r == null){
	        	 roleRepository.save(role); 
	        	 r= roleRepository.findByRole(role.getRole());
	         }
	         Role.add(r);
	          
	        }
			signUpRequest.getRoles().clear();
			signUpRequest.setRoles(Role);
			signUpRequest.setProvider(Provider.LOCAL);
			    ServiceUser.addUser(signUpRequest);
				msg="User have been added succ"; 
		}
		return msg; 
		}
  @PostMapping("/verifieAccount/{Vcode}")
  public ResponseEntity<?> verifieAccount( @Valid @RequestBody LoginRequest loginRequest ,@PathVariable("Vcode") String Vcode) throws MessagingException {
	 User u = userRepository.findByEmail(loginRequest.getEmail());
	 if(ServiceUser.VerifUser(u.getVcode(), Vcode)){
		 u.setEtat(true);
		 userRepository.save(u);
		 return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Your account have been verified  ");
	 }else{
		 return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Your should Reverifie your account  ");
	 }
	  
  }
  
  @PostMapping("/Reverifie")
  public String Reverifie( @Valid @RequestBody LoginRequest loginRequest) throws MessagingException {
	 String  Vcode = EmailController.verificationCode();
	 User u = userRepository.findByEmail(loginRequest.getEmail());
	 u.setVcode(Vcode);
	 EmailController.send(u.getId(), Vcode);
	 userRepository.save(u);
	  return null ; 
	  
  }*/
}
