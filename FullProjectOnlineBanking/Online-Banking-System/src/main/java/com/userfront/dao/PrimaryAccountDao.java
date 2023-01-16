package com.userfront.dao;

import com.userfront.domain.PrimaryAccount;
import org.springframework.data.repository.CrudRepository;

/**
 * repository class for Primary Account domain objects All method names are
 * compliant with Spring Data naming conventions so this interface can easily be
 * extended for Spring
 * 
 * @author Piyumi
 *
 */
public interface PrimaryAccountDao extends CrudRepository<PrimaryAccount, Long> {

	PrimaryAccount findByAccountNumber(int accountNumber);
}
