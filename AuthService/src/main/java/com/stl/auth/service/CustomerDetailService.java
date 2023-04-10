package com.stl.auth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.stl.auth.entity.Customer;
import com.stl.auth.repository.CustomerRepository;

@Component
public class CustomerDetailService implements UserDetailsService{

	@Autowired
	private CustomerRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String customerId) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Customer> credential=repository.findById(Integer.parseInt(customerId));
		return credential.map(CustomerDetails::new).orElseThrow(() -> new UsernameNotFoundException("user not found with name :" + customerId));
	}

}
