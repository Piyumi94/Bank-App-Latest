package com.userfront.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.userfront.domain.PrimaryTransaction;
import com.userfront.domain.SavingsTransaction;
import com.userfront.domain.User;
import com.userfront.service.TransactionService;
import com.userfront.service.UserService;

/**
 * User Resource contoller
 * 
 * @author Piyumi
 *
 */
@RestController
@RequestMapping("/api")
@PreAuthorize("hasRole('ADMIN')")
public class UserResource {

	@Autowired
	private UserService userService;

	@Autowired
	private TransactionService transactionService;

	/**
	 * get all users
	 * 
	 * @return List of User objects
	 */
	@RequestMapping(value = "/user/all", method = RequestMethod.GET)
	public List<User> userList() {
		return userService.findUserList();
	}

	/**
	 * get all Primary Transaction List
	 * 
	 * @param username
	 * @return List of PrimaryTransaction objects
	 */
	@RequestMapping(value = "/user/primary/transaction", method = RequestMethod.GET)
	public List<PrimaryTransaction> getPrimaryTransactionList(@RequestParam("username") String username) {
		return transactionService.findPrimaryTransactionList(username);
	}

	/**
	 * get all Savings Transaction List
	 * 
	 * @param username
	 * @return List of SavingsTransaction objects
	 */
	@RequestMapping(value = "/user/savings/transaction", method = RequestMethod.GET)
	public List<SavingsTransaction> getSavingsTransactionList(@RequestParam("username") String username) {
		return transactionService.findSavingsTransactionList(username);
	}

	/**
	 * enable user
	 * 
	 * @param username
	 */
	@RequestMapping("/user/{username}/enable")
	public void enableUser(@PathVariable("username") String username) {
		userService.enableUser(username);
	}

	/**
	 * disable user
	 * 
	 * @param username
	 */
	@RequestMapping("/user/{username}/disable")
	public void diableUser(@PathVariable("username") String username) {
		userService.disableUser(username);
	}
}
