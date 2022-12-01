package com.example.springsecurity.controllers;

import com.example.springsecurity.models.UserRole;
import com.example.springsecurity.services.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class UserRoleController {
    private final UserRoleService userRoleService;
    @PostMapping()
    public ResponseEntity<UserRole> saveRole(UserRole userRole)
    {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/users/roles").toUriString());
        return ResponseEntity.created(uri).body(userRoleService.saveRole(userRole));
    }
}
