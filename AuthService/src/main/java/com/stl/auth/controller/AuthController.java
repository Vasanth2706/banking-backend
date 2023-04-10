package com.stl.auth.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.net.HttpHeaders;
import com.stl.auth.entity.AuthRequest;
import com.stl.auth.entity.Customer;
import com.stl.auth.entity.RegisterResponse;
import com.stl.auth.entity.TokenResponse;
import com.stl.auth.service.AuthService;
import com.stl.auth.service.JwtService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {
	
    @Autowired
    private AuthService service;
    
    @Autowired
    private JwtService servic;

    @Autowired
    private AuthenticationManager authenticationManager;
    

    @PostMapping("/register")
    public RegisterResponse addNewUser(@RequestBody Customer user) {
        return service.saveUser(user);
    }

    @PostMapping("/token")
    public TokenResponse getToken(@RequestBody AuthRequest authRequest) {
    	try {
    		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getCustomerID(), authRequest.getPassword()));
            if (authenticate.isAuthenticated()) {
            	TokenResponse token= new TokenResponse();
            	token.setSystemTime(LocalDateTime.now());
            	token.setToken(servic.generateToken(authRequest.getCustomerID()));
                return token;
            } else {
                throw new RuntimeException("invalid access");
            }
    	}catch(Error e) {
    		 throw new RuntimeException(e);
    	}
    }

    @GetMapping("/validate")
    public String validateToken(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        servic.validateToken(token.substring(7));
        return "Token is valid";
    }
    
    
}

