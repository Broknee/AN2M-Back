package com.mm.service;

import com.mm.dto.UserDto;
import com.mm.model.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

  User findByEmail(String email);

    List<UserDto> findAllUsers();
   

	void deleteUserById(Long id);
   
}
