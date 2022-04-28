package tn.esprit.spring.controller;

import java.io.UnsupportedEncodingException;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.RoleRepository;
import tn.esprit.spring.service.ServiceUser;
import tn.esprit.spring.service.userService;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@RequestMapping("/api/test")
public class TestController {
	//@Autowired
	//userService us;
	//@Autowired
	//ServiceUser su;
	//@Autowired
	//RoleRepository Rrepository;
 /* @GetMapping("/all")
  public String allAccess() {
    return "Public Content.";
  }

  @GetMapping("/user")
  @PreAuthorize("hasRole('WOMEN') or hasRole('EXPERT') or hasRole('FORMER')")
  public String userAccess() {
    return "User Content.";
  }
  @GetMapping("/retrieve-all-users")
  @PreAuthorize("hasRole('WOMEN')")
	public Set<User> getUsers(){
		return us.retrieveAllUsers();
	}

  @GetMapping("/mod")
  @PreAuthorize("hasRole('WOMEN')")
  public String moderatorAccess() {
    return "Moderator Board.";
  }

  @GetMapping("/admin")
  @PreAuthorize("hasRole('EXPERT')")
  public String adminAccess() {
    return "Admin Board.";
  }
  
  @PostMapping("/process_register")
  public String processRegister(User user, HttpServletRequest request)
        /*  throws UnsupportedEncodingException, MessagingException*/// {
/*	  su.register(user, getSiteURL(request));       
      return "register_success";
  }
   
  private String getSiteURL(HttpServletRequest request) {
      String siteURL = request.getRequestURL().toString();
      return siteURL.replace(request.getServletPath(), "");
  }  */
}
