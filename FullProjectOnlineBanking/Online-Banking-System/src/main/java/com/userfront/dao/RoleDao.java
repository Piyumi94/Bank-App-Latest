package com.userfront.dao;

import org.springframework.data.repository.CrudRepository;

import com.userfront.domain.security.Role;

/**
 * repository class for Role domain objects All method names are compliant with
 * Spring Data naming conventions so this interface can easily be extended for
 * Spring
 * 
 * @author Piyumi
 *
 */
public interface RoleDao extends CrudRepository<Role, Integer> {
	Role findByName(String name);
}
