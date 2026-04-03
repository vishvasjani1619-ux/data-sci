package com.crud.project.service.impl;

import com.crud.project.entity.User;
import com.crud.project.exception.ResourceNotFoundException;
import com.crud.project.repo.UserRepository;
import com.crud.project.request.UserDTO;
import com.crud.project.response.UserResponse;
import com.crud.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    private User convertToEntity(UserDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setStatus(dto.getStatus());
        return user;
    }


    private UserResponse convertToResponse(User user) {
        UserResponse res = new UserResponse();
        res.setId(user.getId());
        res.setName(user.getName());
        res.setEmail(user.getEmail());
        res.setStatus(user.getStatus());
        return res;
    }

    @Override
    public UserResponse createUser(UserDTO dto) {
        User user = convertToEntity(dto);
        return convertToResponse(repository.save(user));
    }

    @Override
    public UserResponse getUser(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return convertToResponse(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return repository.findAll()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse updateUser(Long id, UserDTO dto) {
        User existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        existing.setName(dto.getName());
        existing.setEmail(dto.getEmail());
        existing.setStatus(dto.getStatus());

        return convertToResponse(repository.save(existing));
    }

    @Override
    public void deleteUser(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        repository.delete(user);
    }

}