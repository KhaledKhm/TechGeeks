package tn.esprit.spring.service;



import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;
import tn.esprit.spring.entities.Certificate;
import tn.esprit.spring.entities.Provider;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.RoleName;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.CertificateRepository;
import tn.esprit.spring.repository.RoleRepository;
import tn.esprit.spring.repository.UserRepository;
@Slf4j
@Service
public class ServiceUser implements userService{
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository  roleRepository;
	@Autowired
	CertificateRepository certificateRepository;
	
	@Override
	public void AffecterCertificat(int idUser, List<Certificate> certificates) {
		certificateRepository.saveAll(certificates);
		User u =userRepository.findById(idUser).orElse(null);
		for (Certificate certificate : certificates) {
			certificate.setUser(u);
		}
		certificateRepository.saveAll(certificates);
	}
	
	@Override
	public Set<User> retrieveAllUsers() {
		Set<User> users = new HashSet<User>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	@Override
	public User addUser(User user) {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		user.setEtat(true);
		return userRepository.save(user);
	}

	
	

	@Override
	public User findUserByUserName(String userName) {
		return userRepository.findByUsername(userName);
	}
	public User view(User userName) {
		return userName ;
	}

	public  void processOAuthPostLogin(DefaultOidcUser username,User hamza) {
		String usern = username.getAttribute("email");
		System.out.println(""+username.getAttribute("email"));
		System.out.println(""+hamza);
        if (hamza == null){
            User newUser = new User();
            newUser.setUsername( username.getAttribute("name"));
            newUser.setFirstName( username.getAttribute("given_name"));
            newUser.setLastName(username.getAttribute("family_name"));
            newUser.setEmail( username.getAttribute("email"));
            newUser.setProvider(Provider.GOOGLE);
            newUser.setEtat(true);          
            System.out.print(newUser.getRoles());
            
            userRepository.save(newUser);  
            User u= userRepository.findByEmail(usern);
            Set<Role> Role = new HashSet<Role>();
			Role r = new Role(); 
			r.setIdRole(2);
			Role.add(r);
            u.setRoles(Role);
            userRepository.save(u); 
            
        }
	}

	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}
	
	@Autowired
    private JavaMailSender mailSender;
 
     
 
    public void register(User user, String siteURL)
            throws UnsupportedEncodingException, MessagingException {
    	/*PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);*/
         
        String randomCode = RandomString.make(64);
         
        sendVerificationEmail(user, siteURL);
    }
     
    private void sendVerificationEmail(User user, String siteURL) throws MessagingException, UnsupportedEncodingException {
        String toAddress = "olfa.selmi@esprit.tn";
        String fromAddress = "hamza.krid@esprit.tn";
        String senderName = "HerWay";
        String subject = "Please verify your registration";
        String content = "Dear [[hamza]],<br>"
                + "Please click the link below to verify your registration:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                + "Thank you,<br>"
                + "Your company name.";
         
        MimeMessage message = mailSender.createMimeMessage();
        message.addHeader(content, "hamzaaaaa");
        MimeMessageHelper helper = new MimeMessageHelper(message);
         
        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);
         
        content = content.replace("[[name]]", user.getUsername());
        String verifyURL = siteURL + "/verify?code=" + "halzllaalalala";
         
        content = content.replace("[[URL]]", verifyURL);
         
        helper.setText(content, true);
         
        mailSender.send(message);
         
    }

	@Override
	public User retrieveUserById(Integer iduser) {
		return userRepository.findById(iduser).orElse(null);
	}

	

}
