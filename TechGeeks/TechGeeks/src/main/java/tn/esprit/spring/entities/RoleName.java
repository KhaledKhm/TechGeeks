package tn.esprit.spring.entities;

import org.springframework.security.core.GrantedAuthority;

public enum RoleName implements GrantedAuthority {
	WOMEN,
	EXPERT,
	FORMER;

	@Override
	public String getAuthority() {
		return "ROLE_" + name();
	}
}
