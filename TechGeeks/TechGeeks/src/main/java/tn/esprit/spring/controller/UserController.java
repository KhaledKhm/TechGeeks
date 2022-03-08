package tn.esprit.spring.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Certificate;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.service.IUserService;

@RestController
public class UserController {
	@Autowired
	IUserService userservice;
	
	/*@PostMapping("/AffecterCertificate/{idUser}/{certficates}")
	@ResponseBody
	public void AffecterCertificate(@RequestBody User user,@PathVariable("idUser") int idUser,@PathVariable("certficates") List<Certificate> certficates) {
		userservice.AffecterCertificat(idUser,certficates);
	}*/
}

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.RoleName;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.RoleRepository;
import tn.esprit.spring.service.userService;
@RestController
@CrossOrigin(origins = "*")

public class UserController {
	@Autowired
	userService us;
	@Autowired
	RoleRepository Rrepository;
	
	@GetMapping("/")    
	public String hello() {         
	return "service is up and running";     
	}
	
	@PostMapping("/registration")
	public User createNewUser( @RequestBody User user) {
		Set<Role> Role = new HashSet();
	String msg="";
	User userExists = us.findUserByUserName(user.getUserName());
	if (userExists != null) {
		msg="There is already a user registered with the user name provided";
	} else {
		Set<Role> roles = user.getRoles();
		for (Role role : roles) {
          
         Role r= Rrepository.findByRole(role.getRole());
         if(r == null){
        	 Rrepository.save(role); 
        	 r= Rrepository.findByRole(role.getRole());
         }
         Role.add(r);
          
        }
		    user.getRoles().clear();
		    user.setRoles(Role);
			us.addUser(user);
			msg="User have been added succ"; 
	}
	return user; 
	}
	
	@GetMapping("/retrieve-all-users")
	@Secured ("ROLE_EXPERT")
	public Set<User> getUsers(){
		return us.retrieveAllUsers();
	}
	@GetMapping("/user")
	public Set<Role>  restrected(Principal p,Authentication authentication){
		Set<Role> Role = new HashSet();
		Role r= Rrepository.findByRole(RoleName.WOMEN);
		Role.add(r);
		return Role;
	}

}


