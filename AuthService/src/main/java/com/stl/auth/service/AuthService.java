package com.stl.auth.service;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.stl.auth.entity.Customer;
import com.stl.auth.entity.RegisterResponse;
import com.stl.auth.repository.CustomerRepository;

@Service
public class AuthService {
	
	 	@Autowired
	    private CustomerRepository repository;
	 	
	    @Autowired
	    private AuthenticationManager authenticationManager;
	    
	 	@Autowired
	 	private PasswordEncoder passwordEncoder;
	 	
	    @Autowired
	    private JwtService jwtService;
	    

	    public RegisterResponse saveUser(Customer credential) {
	    	String pass=credential.getPassword();
	    	credential.setAccountId(ThreadLocalRandom.current().nextInt()); 
	        credential.setPassword(passwordEncoder.encode(credential.getPassword()));
	        repository.save(credential);
    		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(Integer.toString(credential.getCustomerId()), pass));
            if (authenticate.isAuthenticated()) {
            	RegisterResponse response=new RegisterResponse();
            	response.setCustomerId(Integer.toString(credential.getCustomerId()));
            	response.setFirstName(credential.getFirstName());
            	response.setLastName(credential.getLastName());
            	response.setToken(jwtService.generateToken(Integer.toString(credential.getCustomerId())));
                return response;
            } else {
                throw new RuntimeException("invalid access");
            }
	    }
	    
//	    public String generateToken(String username) {
//	        return jwtService.generateToken(username);
//	    }
//
//	    public void validateToken(String token) {
//	        jwtService.validateToken(token);
//	    }
}

