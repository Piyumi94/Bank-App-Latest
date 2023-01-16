package com.userfront.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.userfront.domain.SavingsTransaction;

/**
 * repository class for Savings Transactions domain objects All method names are
 * compliant with Spring Data naming conventions so this interface can easily be
 * extended for Spring
 * 
 * @author Piyumi
 *
 */
public interface SavingsTransactionDao extends CrudRepository<SavingsTransaction, Long> {

	List<SavingsTransaction> findAll();
}
