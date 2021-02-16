package com.dev.cinema.controller;

import com.dev.cinema.exception.DataProcessingException;
import com.dev.cinema.model.User;
import com.dev.cinema.model.dto.UserResponseDto;
import com.dev.cinema.service.UserMapper;
import com.dev.cinema.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/by-email")
    public UserResponseDto getByEmail(@RequestParam String email) {
        User user = userService.findByEmail(email).orElseThrow(() ->
                new DataProcessingException("Can't get user with email: " + email));
        return userMapper.getResponseDto(user);
    }
}
