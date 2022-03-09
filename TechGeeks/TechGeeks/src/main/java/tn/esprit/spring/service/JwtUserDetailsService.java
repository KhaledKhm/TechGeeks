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
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import tn.esprit.spring.entities.Role;
//import tn.esprit.spring.entities.User;
//
//@Service
//public class JwtUserDetailsService implements UserDetailsService {
//	@Autowired
//	private UserService userService;
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = userService.findUserByUserName(username);
//		List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
//		return new org.springframework.security.core.userdetails.User(user.getUsername(),
//		user.getPassword(),user.getActive(), true, true, true, authorities);
//	}
//	private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
//		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
//		for (Role role : userRoles) {
//		roles.add(new SimpleGrantedAuthority(role.getRole().name())); }
//		List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
//		return grantedAuthorities;
//		}
//}
