package com.stl.account.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stl.account.dao.TPTAccountDao;
import com.stl.account.model.TPTAccount;

@Service
public class TPTAccountServiceImpl implements TPTAccountService{

	@Autowired
	TPTAccountDao dao;
	
	@Override
	public TPTAccount addBnfAccont(TPTAccount a) {
		a.setModified(LocalDateTime.now());
		return dao.save(a);
	}

	@Override
	public List<TPTAccount> searchByCustomer(int id) {
		return dao.searchByCustomerId(id);
	}

}
