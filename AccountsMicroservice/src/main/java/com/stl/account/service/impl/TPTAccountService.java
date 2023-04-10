package com.stl.account.service.impl;

import java.util.List;

import com.stl.account.model.TPTAccount;

public interface TPTAccountService {
	public TPTAccount addBnfAccont(TPTAccount a); 
	public List<TPTAccount> searchByCustomer(int id); 
}
