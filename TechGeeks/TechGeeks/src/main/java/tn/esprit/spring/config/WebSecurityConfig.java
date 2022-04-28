package tn.esprit.spring.config;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.RoleName;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.RoleRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.security.CustomOAuth2UserService;
import tn.esprit.spring.security.UserDetailsServiceImpl;
import tn.esprit.spring.security.jwt.AuthEntryPointJwt;
import tn.esprit.spring.security.jwt.AuthTokenFilter;
import tn.esprit.spring.service.ServiceUser;




@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(
    // securedEnabled = true,
    // jsr250Enabled = true,
 //   prePostEnabled = true)
public class WebSecurityConfig /*extends WebSecurityConfigurerAdapter */{

//	@Autowired
//    private CustomOAuth2UserService oauthUserService;
//	@Autowired
 //   private UserRepository UserRepository;
//	@Autowired
 //   private ServiceUser UserService;
//	@Autowired
//	RoleRepository Rrepository;
	
//  @Autowired
//  UserDetailsServiceImpl userDetailsService;

  //@Autowired
  //private AuthEntryPointJwt unauthorizedHandler;

 /* @Bean
  public AuthTokenFilter authenticationJwtTokenFilter() {
    return new AuthTokenFilter();
  }*/

 /* @Override
  public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
	  PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(encoder);
  }

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }
*/

 // @Override
 // protected void configure(HttpSecurity http) /*throws Exception */{
//	  http
//		.authorizeRequests()
//		.antMatchers("/api/auth/**").permitAll();
/*		.anyRequest()
		.authenticated()
		.and()
		.oauth2Login()
		.userInfoEndpoint()
      .userService(oauthUserService)
       .and()
       .successHandler(new AuthenticationSuccessHandler(){
			@Override
			public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
					Authentication authentication) throws IOException, ServletException {
				// TODO Auto-generated method stub
				DefaultOidcUser oauthUser = (DefaultOidcUser) authentication.getPrincipal();
				String email = oauthUser.getAttribute("given_name");
				
				User existUser =UserService.findUserByEmail(oauthUser.getAttribute("email"));
				UserService.processOAuthPostLogin(oauthUser,existUser);
				
			}
      	     })
       .and()
       .httpBasic().and().csrf().disable();*/
 // }
}
