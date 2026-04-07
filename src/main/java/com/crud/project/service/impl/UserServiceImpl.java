package com.crud.project.service.impl;

import com.crud.project.entity.User;
import com.crud.project.exception.ResourceNotFoundException;
import com.crud.project.repo.UserRepository;
import com.crud.project.request.UserDTO;
import com.crud.project.response.UserResponse;
import com.crud.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public UserResponse createUser(UserDTO dto) {

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setStatus(dto.getStatus());

        User saved = repository.save(user);

        UserResponse res = new UserResponse();
        res.setId(saved.getId());
        res.setName(saved.getName());
        res.setEmail(saved.getEmail());
        res.setStatus(saved.getStatus());

        return res;
    }

    @Override
    public UserResponse getUser(Long id) {

        User user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        UserResponse res = new UserResponse();
        res.setId(user.getId());
        res.setName(user.getName());
        res.setEmail(user.getEmail());
        res.setStatus(user.getStatus());

        return res;
    }

    @Override
    public List<UserResponse> getAllUsers() {

        List<User> users = repository.findAll();
        List<UserResponse> responseList = new ArrayList<>();

        for (User user : users) {
            UserResponse res = new UserResponse();
            res.setId(user.getId());
            res.setName(user.getName());
            res.setEmail(user.getEmail());
            res.setStatus(user.getStatus());

            responseList.add(res);
        }

        return responseList;
    }

    @Override
    public UserResponse updateUser(Long id, UserDTO dto) {

        User existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        existing.setName(dto.getName());
        existing.setEmail(dto.getEmail());
        existing.setStatus(dto.getStatus());

        User updated = repository.save(existing);

        UserResponse res = new UserResponse();
        res.setId(updated.getId());
        res.setName(updated.getName());
        res.setEmail(updated.getEmail());
        res.setStatus(updated.getStatus());

        return res;
    }

    @Override
    public void deleteUser(Long id) {

        User user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        repository.delete(user);
    }
}