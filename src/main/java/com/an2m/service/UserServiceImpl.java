package com.an2m.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.an2m.dto.UserDto;
import com.an2m.dto.userDtoGet;
import com.an2m.model.Role;
import com.an2m.model.User;
import com.an2m.repository.RoleRepository;
import com.an2m.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
			PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void saveUser(UserDto userDto) {
		User user = new User();
		user.setName(userDto.getFirstName() + " " + userDto.getLastName());
		user.setEmail(userDto.getEmail());
		System.out.println(userDto.getPassword());
		System.out.println(userDto.getFirstName());
		System.out.println(userDto.getLastName());
        
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		
     User userExit=userRepository.findByEmail(userDto.getEmail());
		if (userExit==null) {
	Role	role = checkRoleExist(userDto.getRoles());

		user.setRoles(Arrays.asList(role));
		userRepository.save(user);
		}
		

	}
	
	public void modifyUserInfo(UserDto userDto) {
		
		 
		Optional<User> user =userRepository.findById(userDto.getId()) ;
		 System.out.println(user.get().getId());
		user.get().setPassword(userDto.getPassword());
		user.get().setId(userDto.getId());
		
		user.get().setName(userDto.getFirstName() + " " + userDto.getLastName());
		user.get().setEmail(userDto.getEmail());
	   
		userRepository.save(user.get());
		
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public List<userDtoGet> findAllUsers() {
		List<User> users = userRepository.findAll();
		return users.stream().map((user) -> convertEntityToDto(user)).collect(Collectors.toList());
	}

	private userDtoGet convertEntityToDto(User user) {
	userDtoGet userDto = new userDtoGet();
		String[] name = user.getName().split(" ");
		userDto.setFirstName(name[0]);
		userDto.setLastName(name[1]);
		userDto.setEmail(user.getEmail());
		userDto.setId(user.getId());
		userDto.setPassword(user.getPassword());
		// On boucle sur les roles pour recuperer les noms des roles du User en question
		for (Role element : user.getRoles()) {
			userDto.getRoles().add(element.getName());
		}

		return userDto;
	}

	private Role checkRoleExist(String assignation) {
		Role role = new Role();
		role.setName(assignation);
		return roleRepository.save(role);
	}

	@Override
	public void deleteUserById(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

}
