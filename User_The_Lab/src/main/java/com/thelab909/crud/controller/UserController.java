package com.thelab909.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thelab909.crud.model.User;
import com.thelab909.crud.service.UserServiceImpl;

@Controller
public class UserController {
	
	@Autowired
	private UserServiceImpl service;
	
	@GetMapping("/")
	public String  viewHomePage(Model model) {
		model.addAttribute("title","Home- User Details Management");
		return "home";
	}
	@RequestMapping("/search")
	public String search(Model model) {
		model.addAttribute("title","Search-User Details Manager");
		return "search";
	}
	@RequestMapping("/details")
	public String details(Model model) {
		model.addAttribute("title","Search-User Details Manager");
		return "details";
	}
	@GetMapping("/details-user")
	public String getAllUsers(Model model) {
		model.addAttribute("listUsers", service.getUsers());
		return "details";
		
	}
    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model) {
        // create model attribute to bind form data
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        // save employee to database
        service.saveUser(user);
        return "redirect:/details-user";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get employee from the service
        User use = service.getUserById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("user", use);
        return "update_user";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value="id") Long id) {
    	this.service.deleteUserById(id);
    	return "redirect:/";
    }
}
