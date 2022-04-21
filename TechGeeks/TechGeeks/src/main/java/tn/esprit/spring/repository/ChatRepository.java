package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat,Integer>{

}
