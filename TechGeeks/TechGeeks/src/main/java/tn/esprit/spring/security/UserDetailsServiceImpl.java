package tn.esprit.spring.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;



@Service
public class UserDetailsServiceImpl /*implements UserDetailsService*/{
//  @Autowired
//  UserRepository userRepository;

 /* @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username);

    return UserDetailsImpl.build(user);
  }*/

}
