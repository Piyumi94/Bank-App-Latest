package com.userfront.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.userfront.domain.PrimaryTransaction;

/**
 * repository class for Primary Transaction domain objects All method names are
 * compliant with Spring Data naming conventions so this interface can easily be
 * extended for Spring
 * 
 * @author Piyumi
 *
 */
public interface PrimaryTransactionDao extends CrudRepository<PrimaryTransaction, Long> {

	List<PrimaryTransaction> findAll();
}
