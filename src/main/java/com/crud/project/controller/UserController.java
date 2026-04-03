package com.crud.project.controller;

import com.crud.project.request.UserDTO;
import com.crud.project.response.UserResponse;
import com.crud.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    @PostMapping("/create")
    public UserResponse create(@RequestBody UserDTO dto) {
        return service.createUser(dto);
    }

    @GetMapping("/getUser/{id}")
    public UserResponse get(@PathVariable Long id) {
        return service.getUser(id);
    }

    @GetMapping("/getAllUsers")
    public List<UserResponse> getAll() {
        return service.getAllUsers();
    }

    @PutMapping("/update/{id}")
    public UserResponse update(@PathVariable Long id, @RequestBody UserDTO dto) {
        return service.updateUser(id, dto);
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteUser(id);
        return "User deleted successfully";
    }
}

