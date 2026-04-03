package com.crud.project.service;

import com.crud.project.request.UserDTO;
import com.crud.project.response.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createUser(UserDTO dto);

    UserResponse getUser(Long id);

    List<UserResponse> getAllUsers();

    UserResponse updateUser(Long id, UserDTO dto);

    void deleteUser(Long id);
}
