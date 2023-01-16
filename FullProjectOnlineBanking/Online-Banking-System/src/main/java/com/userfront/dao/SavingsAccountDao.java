package com.userfront.dao;

import com.userfront.domain.SavingsAccount;
import org.springframework.data.repository.CrudRepository;

/**
 * repository class for Savings Account domain objects All method names are
 * compliant with Spring Data naming conventions so this interface can easily be
 * extended for Spring
 * 
 * @author Piyumi
 *
 */
public interface SavingsAccountDao extends CrudRepository<SavingsAccount, Long> {

	SavingsAccount findByAccountNumber(int accountNumber);
}
