package com.example.bank.controller;

import com.example.bank.dto.AuthenticationRequest;
import com.example.bank.entity.User;
import com.example.bank.exception.AuthenticationException;
import com.example.bank.exception.UserAlreadyExistsException;
import com.example.bank.repository.UserRepository;
import com.example.bank.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;


@RestController
public class AuthController {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(UserRepository userRepository, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/authenticate")
    public String createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse response) {
        User user = userRepository.findByLogin(authenticationRequest.getUsername())
                .orElseThrow(() -> new AuthenticationException("Invalid credentials"));

        if (!passwordEncoder.matches(authenticationRequest.getPassword(), user.getPassword())) {
            throw new AuthenticationException("Invalid credentials");
        }

        String jwt = jwtUtil.generateToken(user);
        addJwtCookieToResponse(response, jwt);
        return "Authentication successful";
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody AuthenticationRequest authenticationRequest) {
        userRepository.findByLogin(authenticationRequest.getUsername())
                .ifPresent(existingUser -> {
                    throw new UserAlreadyExistsException("User already exists with this login");
                });
        User user = new User();
        user.setPassword(passwordEncoder.encode(authenticationRequest.getPassword()));
        user.setLogin(authenticationRequest.getUsername());
        userRepository.save(user);
        return "User registered successfully";
    }

    private void addJwtCookieToResponse(HttpServletResponse response, String jwt) {
        Cookie jwtCookie = new Cookie("jwtToken", jwt);
        jwtCookie.setHttpOnly(true);
        jwtCookie.setSecure(true);
        jwtCookie.setPath("/");
        jwtCookie.setMaxAge(60 * 2);
        response.addCookie(jwtCookie);
    }
}
