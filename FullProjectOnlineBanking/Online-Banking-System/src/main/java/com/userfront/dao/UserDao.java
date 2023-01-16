package com.userfront.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.userfront.domain.User;

/**
 * repository class for User domain objects All method names are compliant with
 * Spring Data naming conventions so this interface can easily be extended for
 * Spring
 * 
 * @author Piyumi
 *
 */
public interface UserDao extends CrudRepository<User, Long> {
	User findByUsername(String username);

	User findByEmail(String email);

	List<User> findAll();
}
