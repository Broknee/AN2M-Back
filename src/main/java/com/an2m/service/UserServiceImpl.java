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
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
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
        user.setPassword(userDto.getPassword());
        

        //encrypt the password once we integrate spring security
        //user.setPassword(userDto.getPassword()); 
        //Role role = roleRepository.findByName("ROLE_USER");
        Role role;
        
        
        role = checkRoleExist(userDto.getAssignation());
       
        user.setRoles(Arrays.asList(role));
      
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> convertEntityToDto(user))
                .collect(Collectors.toList());
    }

    private UserDto convertEntityToDto(User user){
        UserDto userDto = new UserDto();
        String[] name = user.getName().split(" ");
        userDto.setFirstName(name[0]);
        userDto.setLastName(name[1]);
        userDto.setEmail(user.getEmail());
          userDto.setId(user.getId());
//          List<Role> roles=new ArrayList<Role>();
//          
//          roles=user.getRoles();
//          
//        		  userDto.setRoles(roles);
//        		  List<Role> roles1=new ArrayList<Role>();
//                roles1= userDto.getRoles();
//          for (Role role : roles1) {
//        	  System.out.println(role.getName());
			
		//}
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
