package com.an2m.service;

import com.an2m.dto.UserDto;
import com.an2m.dto.userDtoGet;
import com.an2m.model.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

  User findByEmail(String email);

    List<userDtoGet> findAllUsers();
   

	void deleteUserById(Long id);
   
}
