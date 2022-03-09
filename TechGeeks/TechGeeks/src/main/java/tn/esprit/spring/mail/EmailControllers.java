package tn.esprit.spring.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class EmailControllers {
	
	 @Autowired
		JavaMailSender mailSender;

	  
	  @GetMapping("/test")
		public String send(){
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("hamza.krid@esprit.tn");
			message.setTo("amal.soltani1@esprit.tn");
			message.setSubject("Verification message");
			message.setText("Has been validated !");
			mailSender.send(message);
			
			return "done";
		}
	  
	  @GetMapping("/Verification/{mail}/{username}/{Firstname}")
	  
	  public String ApplicationMail(@PathVariable("mail") String Mail ,@PathVariable("username") String username, @PathVariable("Firstname")String Firstname)
	  {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("hamza.krid@esprit.tn");
			message.setTo(Mail);
			message.setText("Mr/Mrs : "+Firstname+ "\n Your account : " +username+ " Has been validated !");
			message.setSubject("Mail Verification");
			mailSender.send(message);
		 
		    return "Successfully sent";
	  }
	  
	



}
