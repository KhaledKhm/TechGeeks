//package tn.esprit.spring.service;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import lombok.extern.slf4j.Slf4j;
//import tn.esprit.spring.entities.Role;
//import tn.esprit.spring.entities.User;
//@Slf4j
//@Service
//public class TheUserDetailsService implements UserDetailsService {
//
//	@Autowired
//	userService us;
//	
//	@Override
//	@Transactional
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = us.findUserByUserName(username);
//		List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
//		return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),user.getActive(), true,true,true, authorities);
//	}
//
//	
//	private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
//		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
//		for (Role role : userRoles) {
//		roles.add(new SimpleGrantedAuthority(role.getRole().getAuthority())); }
//		List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
//		return grantedAuthorities;
//	}
//
//}
