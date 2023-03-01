package com.an2m.controller;

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
import com.an2m.model.User;
import com.an2m.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RestController
@RequestMapping(path = "api")
public class AuthController {

	private UserService userService;

	public AuthController(UserService userService) {
		this.userService = userService;
	}

	
	
	
	// handler method to handle user registration request
	@PostMapping("/modifyUserInfo")
	public String modifyUserInfo(@RequestBody UserDto userDto) {
		System.out.println(userDto.getId()+userDto.getFirstName()+userDto.getLastName());
		 userService.modifyUserInfo(userDto);
		 System.out.println(userDto.getId()+userDto.getFirstName()+userDto.getLastName());
		
		return "Modified";
	}

	@GetMapping("/error403")
	public String getAccessDenied() {
		return "/user/error403";
	}

	// handler method to handle register user form submit request
	@PostMapping("/save")
	public String registration(@RequestBody UserDto user) {
		 User existing = userService.findByEmail(user.getEmail());
		if(existing!=null)return "email exist";
//		if(user.getPassword()==null) {
//			  User  existUser = userService.findById(user.getId());
//			    myCustomer.phone = phone;
//			    repo.save(myCustomer);
//			
			
		

		userService.saveUser(user);
		return "ok";
	}

	@GetMapping("/delete_user/{id}")
	public String deleteUser(@PathVariable(value = "id") Long id) {
		userService.deleteUserById(id);

		return "ok";
	}

	@GetMapping("/users")
	public List<userDtoGet> listRegisteredUsers() {
	
		return userService.findAllUsers();
	}
}
