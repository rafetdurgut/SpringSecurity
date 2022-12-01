package com.example.springsecurity;

import com.example.springsecurity.models.User;
import com.example.springsecurity.models.UserRole;
import com.example.springsecurity.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder()
    {
       return  new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService)
    {
        return args->
        {
            userService.saveRole(new UserRole(null,"ROLE_USER"));
            userService.saveRole(new UserRole(null,"ROLE_MANAGER"));
            userService.saveRole(new UserRole(null,"ROLE_ADMIN"));

            userService.saveUser(new User(null,"rafet","rdurgut","12345",new ArrayList<>()));

            userService.addRoleToUser("rdurgut","ROLE_USER");

        };
    }
}
