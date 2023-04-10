package com.stl.account.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stl.account.model.Account;

@Service
public interface AccountsService {
	public Optional<Account> getCustomer(String a);
	
	public Optional<Account> getAccount(String a);
	
	public Account updateCustomerInfo(Account a);
	
	public Account addCustomer(Account a);

}
