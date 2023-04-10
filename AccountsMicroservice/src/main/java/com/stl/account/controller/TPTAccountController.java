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

import com.stl.account.model.TPTAccount;
import com.stl.account.service.impl.TPTAccountService;

@RestController
@RequestMapping("accounts")
@CrossOrigin(origins = "http://localhost:3000")
public class TPTAccountController {
	
	@Autowired
	TPTAccountService service;
	
	@PostMapping("/thirdparty/add")
	public ResponseEntity<TPTAccount> addAccount(@RequestBody TPTAccount user){
		return new ResponseEntity(service.addBnfAccont(user),HttpStatus.OK);
	}

	@GetMapping("/thirdparty/{customerId}")
	public ResponseEntity<TPTAccount> searchByCustomerId(@PathVariable(name="customerId") String id){
		return new ResponseEntity(service.searchByCustomer(Integer.parseInt(id)),HttpStatus.OK);
	}
}
