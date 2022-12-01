package com.example.springsecurity.controllers;

import com.example.springsecurity.models.User;
import com.example.springsecurity.models.UserRole;
import com.example.springsecurity.services.UserRoleService;
import com.example.springsecurity.services.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRoleService userRoleService;
    @GetMapping()
    public ResponseEntity<?> getAllUsers()
    {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping()
    public ResponseEntity<User> saveUser(User user)
    {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/users").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/roles")
    public ResponseEntity<?> addRoleToUser(@RequestBody UserRoleForm form)
    {
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok("Successful!");
    }
}
@Data
class UserRoleForm
{
    private String username;
    private String roleName;
}
