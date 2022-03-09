//package tn.esprit.spring.config;
//
//
//import java.io.IOException;
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//
//import tn.esprit.spring.entities.CustomOAuth2User;
//import tn.esprit.spring.entities.Role;
//import tn.esprit.spring.entities.RoleName;
//import tn.esprit.spring.entities.User;
//import tn.esprit.spring.repository.RoleRepository;
//import tn.esprit.spring.service.CustomOAuth2UserService;
//import tn.esprit.spring.service.TheUserDetailsService;
//import tn.esprit.spring.service.userService;
//import tn.esprit.spring.service.userServiceImpl;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
//	@Autowired
//	private TheUserDetailsService userDetailsService;
//	@Autowired
//    private CustomOAuth2UserService oauthUserService;
//	@Autowired
//    private userServiceImpl UserService;
//	@Autowired
//	RoleRepository Rrepository;
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//   PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	auth.userDetailsService(userDetailsService).passwordEncoder(encoder);}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//		.authorizeRequests()
//		.antMatchers("/registration").permitAll()
//		.anyRequest()
//		.authenticated()
//		.and()
//		.oauth2Login()
//		.userInfoEndpoint()
//        .userService(oauthUserService)
//         .and()
//         .successHandler(new AuthenticationSuccessHandler(){
//			@Override
//			public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//					Authentication authentication) throws IOException, ServletException {
//				// TODO Auto-generated method stub
//				DefaultOidcUser oauthUser = (DefaultOidcUser) authentication.getPrincipal();
//				String email = oauthUser.getAttribute("given_name");
//				Set<Role> Role = new HashSet();
//				Role r= new Role();
//				Role h= Rrepository.findByRole(RoleName.WOMEN);
//				r.setId(h.getId());
//				r.setRole(h.getRole());
//				Role.add(r);
//				User existUser =UserService.findUserByEmail(oauthUser.getAttribute("email"));
//				UserService.processOAuthPostLogin(oauthUser,existUser,Role);
//				
//			}
//        	     })
//         .and()
//         .httpBasic().and().csrf().disable();
//		
//		}
//
//}
