package com.myapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myapp.persistence.UserEntity;
import com.myapp.service.UserService;
import com.myapp.service.impl.UserValidator;
/**
 * user controller to create user and login 
 * 
 
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserValidator userValidator;
	
	/* load the registration page*/
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userForm", new UserEntity());

		return "registration";
	}

	/* saves  registration page*/
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(Model model,@ModelAttribute("userForm") UserEntity userForm, BindingResult bindingResult) {
		userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "registration";
		}

		userService.save(userForm);

		

		model.addAttribute("flag", "true");
		return "login";
	}
	
	/* loads the login page*/
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");
		model.addAttribute("userForm", new UserEntity());

		return "login";
	}
	/* calls when user clicks login page submit button */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, String error, String logout, @ModelAttribute("userForm") UserEntity user,
			HttpServletRequest req) {
		
		if (userService.findByUsername(user.getUsername()) != null
				&& userService.findByUsername(user.getUsername()).getPassword().equals(user.getPassword())) {
			req.getSession().setAttribute("user", user);
			return "redirect:/currency-converter";
		}
		else{
			error="user not exists";
		}
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");
		return "login";
	}
	/* calls when user clicks on logout button */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String login(Model model, String error, String logout,
			HttpServletRequest req) {
		logout="logout successful";
		req.getSession().invalidate();
		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");
		return "login";
	}
}