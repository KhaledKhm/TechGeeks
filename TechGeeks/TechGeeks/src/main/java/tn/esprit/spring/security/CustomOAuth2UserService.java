package tn.esprit.spring.security;


import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.CustomOAuth2User;

@Service
public class CustomOAuth2UserService /*extends DefaultOAuth2UserService*/  {

  /* @Override
   public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
       OAuth2User user =  super.loadUser(userRequest);
       return new CustomOAuth2User(user);
   }*/

}
