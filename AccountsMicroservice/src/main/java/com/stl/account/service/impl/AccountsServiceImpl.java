package com.stl.account.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stl.account.dao.AccountsDao;
import com.stl.account.model.Account;

@Service
public class AccountsServiceImpl implements AccountsService{
	
	@Autowired
	AccountsDao dao;

	@Override
	public Optional<Account> getCustomer(String customerId) {
		// TODO Auto-generated method stub
		return dao.findById(Integer.parseInt(customerId)); 
	}

	@Override
	public Optional<Account> getAccount(String a) {
		// TODO Auto-generated method stub
		List<Account>customers=dao.searchByAccountId(Integer.parseInt(a));
		return customers.isEmpty()?null:Optional.ofNullable(customers.get(0));
	}

	@Override
	public Account updateCustomerInfo(Account a) {
		// TODO Auto-generated method stub
		if(dao.updateTitle(a.getCustomerId(), a.getFirstName(), a.getLastName(), a.getEmail(), a.getPhone(), a.getIfscCode())==1) {
			return a;  
		}else {
			throw new RuntimeException("Request Failed");
		}
		
	}

	@Override
	public Account addCustomer(Account a) {
		// TODO Auto-generated method stub
		
		return dao.save(a);
	}

}