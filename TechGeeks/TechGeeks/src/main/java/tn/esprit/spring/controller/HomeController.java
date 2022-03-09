//package tn.esprit.spring.controller;
//
//import java.util.List;
//
//import javax.websocket.server.PathParam;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import tn.esprit.spring.entities.User;
//import tn.esprit.spring.service.UserService;
//
//
//@RestController
//public class HomeController {
//@Autowired
//UserService userService;
//@PostMapping("/registration")
//public String createNewUser( @RequestBody User user) {
//String msg="";
//User userExists = userService.findUserByUserName(user.getUserName());
//if (userExists != null) {
//msg="There is already a user registered with the user name provided";
//} else {
//userService.addUser(user);
//msg="OK"; }
//return msg; }
//
//@GetMapping("/getUsers")
//public List<User> getUsers() {
//	return (List<User>) userService.retrieveAllUsers();
//}
//////@GetMapping("/getUsers/{id}")
//////public User getUser(@PathVariable Integer id) {
//////	return  userService.retrieveUser(id);
//////}
//////@PostMapping("/deleteUser/{id}")
//////public void deleteUser(@PathVariable Integer id) {
//////	userService.deleteUser(id);
////}
//@PutMapping("/updateUser")
//public void updateUser(@RequestBody User User) {
//	userService.addUser(User);
//}
//}
