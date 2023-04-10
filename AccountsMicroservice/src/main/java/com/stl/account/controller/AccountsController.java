package com.stl.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stl.account.model.Account;
import com.stl.account.payload.RegisterResponse;
import com.stl.account.service.impl.AccountsService;


@RestController
@RequestMapping("accounts")
@CrossOrigin(origins = "http://localhost:3000")
public class AccountsController {
	
	@Autowired
	AccountsService service;
	
	
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<Account> getCustomer(@PathVariable(name="customerId") String id){
		return new ResponseEntity(service.getCustomer(id),HttpStatus.OK);
	}
	
	
	@GetMapping("/account/{accountId}")
	public ResponseEntity<Account> getAccount(@PathVariable(name="accountId") String id){
		return new ResponseEntity(service.getAccount(id),HttpStatus.OK);
	}
	
	
	@PostMapping("/update")
	public ResponseEntity<Account> updateCustomerInfo(@RequestBody Account user){
		return new ResponseEntity(service.updateCustomerInfo(user),HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Account> addCustomer(@RequestBody Account user){
		return new ResponseEntity(service.addCustomer(user),HttpStatus.OK);
	}
}
