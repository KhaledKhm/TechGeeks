package tn.esprit.spring.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.RoleName;

@Repository
public interface RoleRepository extends CrudRepository<Role,Integer> {
	Role findByRole(RoleName roleName);
}
