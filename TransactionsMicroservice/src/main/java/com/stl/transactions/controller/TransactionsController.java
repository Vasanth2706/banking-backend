package com.stl.transactions.controller;

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

import com.stl.transactions.model.Transactions;
import com.stl.transactions.service.TransactionsService;



@RestController
@RequestMapping("transactions")
@CrossOrigin(origins = "http://localhost:3000")
public class TransactionsController {
	
	@Autowired
	TransactionsService service;
	
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<Transactions> getCustomer(@PathVariable(name="customerId") int id){
		return new ResponseEntity(service.getTransactions(id),HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Transactions> updateCustomerInfo(@RequestBody Transactions user){
		return new ResponseEntity(service.fundTransfer(user),HttpStatus.OK); 
	}
}
