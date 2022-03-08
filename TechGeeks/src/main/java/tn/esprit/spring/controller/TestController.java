package tn.esprit.spring.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.RoleRepository;
import tn.esprit.spring.service.userService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	@Autowired
	userService us;
	@Autowired
	RoleRepository Rrepository;
  @GetMapping("/all")
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
}
