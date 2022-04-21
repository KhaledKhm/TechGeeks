package tn.esprit.spring.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.service.ServiceUser;
@RestController
public class EmailControllers {
	
	 @Autowired
		JavaMailSender mailSender;
	 @Autowired
	  ServiceUser ServiceUser;
	  
	  @GetMapping("/test/{id}")
		public String send(@PathVariable("id") Integer Id,String verificationCode) throws MessagingException{
		  User u = ServiceUser.retrieveUserById(Id);
		  MimeMessage msg = mailSender.createMimeMessage();
		  MimeMessageHelper message = new MimeMessageHelper(msg, true);
			String content = "Dear [[name]],<br>"
	                + "This is your verifacation Code:"+verificationCode;
			message.setFrom("hamza.krid@esprit.tn");
			message.setTo(u.getEmail());
			message.setSubject("Verification message");
			
	        
			message.setText(content);
			mailSender.send(msg);
			
			return "done";
		}
	  
	  
	  public String verificationCode(){
			String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+"0123456789"+"abcdefghijklmnopqrstuvxyz";
			StringBuilder sb = new StringBuilder(5);
			for (int i = 0; i < 5; i++) {
			int index = (int)(AlphaNumericString.length()* Math.random());
			sb.append(AlphaNumericString.charAt(index));
			}
			return sb.toString();
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
