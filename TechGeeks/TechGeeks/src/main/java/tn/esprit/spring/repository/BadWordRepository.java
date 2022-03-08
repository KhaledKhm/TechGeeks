package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.BadWord;


@Repository
public interface BadWordRepository extends CrudRepository<BadWord ,Long> {

}
