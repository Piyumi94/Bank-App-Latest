package com.userfront.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.userfront.domain.Recipient;

/**
 * repository class for Recipient domain objects All method names are compliant
 * with Spring Data naming conventions so this interface can easily be extended
 * for Spring
 * 
 * @author Piyumi
 *
 */
public interface RecipientDao extends CrudRepository<Recipient, Long> {
	List<Recipient> findAll();

	Recipient findByName(String recipientName);

	void deleteByName(String recipientName);
}
