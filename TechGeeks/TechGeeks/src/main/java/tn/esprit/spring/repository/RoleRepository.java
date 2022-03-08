package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.RoleName;
import tn.esprit.spring.entities.User;

@Repository
public interface RoleRepository extends CrudRepository<Role,Integer> {
	Role findByRole(RoleName re);
}
