package tn.esprit.spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.OffreCategory;


@Repository
public interface OffreCategoryRepository extends JpaRepository<OffreCategory,Integer> {

}
