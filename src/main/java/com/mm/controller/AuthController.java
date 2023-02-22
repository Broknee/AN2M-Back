package com.mm.controller;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mm.dto.UserDto;
import com.mm.model.User;
import com.mm.service.UserService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RestController
@RequestMapping(path = "api")
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home1(){
        return "index";
    }
    @GetMapping("/index")
    public String home2(){
        return "index";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    // handler method to handle user registration request
    @GetMapping("register")
    public String showRegistrationForm(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }
    
    @GetMapping("/error403")
    public String getAccessDenied() {
        return "/user/error403";
    }

    // handler method to handle register user form submit request
    @PostMapping("/register/save")
    public String registration(@Validated @ModelAttribute("user") UserDto user,
                               BindingResult result,
                               Model model){
        User existing = userService.findByEmail(user.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/register?success";
    }

    @GetMapping("/delete_user/{id}")
    public String deleteUser(@PathVariable(value = "id") Long id) {
    	userService.deleteUserById(id);
    	
    	return "redirect:/users";
    }
    @GetMapping("/users")
    public List<UserDto> listRegisteredUsers(Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return userService.findAllUsers();
    }
}
