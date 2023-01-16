package com.userfront.controller;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.userfront.dao.RoleDao;
import com.userfront.domain.PrimaryAccount;
import com.userfront.domain.SavingsAccount;
import com.userfront.domain.User;
import com.userfront.domain.security.UserRole;
import com.userfront.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

/**
 * home page controller
 * 
 * @author Piyumi
 *
 */
@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleDao roleDao;

	/**
	 * load base page
	 * 
	 * @return index page
	 */
	@RequestMapping("/")
	public String home() {
		return "redirect:/index";
	}

	/**
	 * load index page
	 * 
	 * @return index page
	 */
	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	/**
	 * load signup page
	 * 
	 * @param model
	 * @return signup page
	 */
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {
		User user = new User();

		model.addAttribute("user", user);

		return "signup";
	}

	/**
	 * load sign up page if user exist or otherwise create user and rediret to base
	 * page
	 * 
	 * @param user
	 * @param model
	 * @return signup page / base page
	 */
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPost(@ModelAttribute("user") User user, Model model) {

		if (userService.checkUserExists(user.getUsername(), user.getEmail())) {

			if (userService.checkEmailExists(user.getEmail())) {
				model.addAttribute("emailExists", true);
			}

			if (userService.checkUsernameExists(user.getUsername())) {
				model.addAttribute("usernameExists", true);
			}

			return "signup";
		} else {
			Set<UserRole> userRoles = new HashSet<>();
			userRoles.add(new UserRole(user, roleDao.findByName("ROLE_USER")));

			userService.createUser(user, userRoles);

			return "redirect:/";
		}
	}

	/**
	 * load userFront page
	 * 
	 * @param principal
	 * @param model
	 * @return userFront page
	 */
	@RequestMapping("/userFront")
	public String userFront(Principal principal, Model model) {
		User user = userService.findByUsername(principal.getName());
		PrimaryAccount primaryAccount = user.getPrimaryAccount();
		SavingsAccount savingsAccount = user.getSavingsAccount();

		model.addAttribute("primaryAccount", primaryAccount);
		model.addAttribute("savingsAccount", savingsAccount);

		return "userFront";
	}

}
