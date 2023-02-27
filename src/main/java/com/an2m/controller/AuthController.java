package com.an2m.controller;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.an2m.dto.UserDto;
import com.an2m.dto.userDtoGet;
import com.an2m.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RestController
@RequestMapping(path = "api")
@Slf4j
public class AuthController {

	private UserService userService;

	public AuthController(UserService userService) {
		this.userService = userService;
	}

	// handler method to handle user registration request
	@GetMapping("register")
	public String showRegistrationForm(Model model) {
		UserDto user = new UserDto();
		model.addAttribute("user", user);
		return "register";
	}

	@GetMapping("/error403")
	public String getAccessDenied() {
		return "/user/error403";
	}

	// handler method to handle register user form submit request
	@PostMapping("/save")
	public String registration(@RequestBody UserDto user) {
		// User existing = userService.findByEmail(user.getEmail());

		userService.saveUser(user);
		return "ok";
	}

	@GetMapping("/delete_user/{id}")
	public String deleteUser(@PathVariable(value = "id") Long id) {
		userService.deleteUserById(id);
		return"ok";
		
	}

    

	@GetMapping("/users")
	public List<userDtoGet> listRegisteredUsers(Model model) {
		List<userDtoGet> users = userService.findAllUsers();
		model.addAttribute("users", users);
		return userService.findAllUsers();
	}
}
