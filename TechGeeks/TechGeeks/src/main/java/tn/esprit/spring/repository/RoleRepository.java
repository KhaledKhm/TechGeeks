package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role,Integer> {
Role findByRole(String role);
}