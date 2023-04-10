package com.stl.transactions.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stl.transactions.dao.TransactionsDao;
import com.stl.transactions.model.Transactions;

@Service
public class TransactionsServiceImpl implements TransactionsService{

	@Autowired
	TransactionsDao dao;
	
	@Override
	public Transactions fundTransfer(Transactions a) {
		// TODO Auto-generated method stub
		a.setTimeStamp(LocalDateTime.now());
		return dao.save(a); 
	}

	@Override
	public List<Transactions> getTransactions(int customerId) {
		// TODO Auto-generated method stub
		return dao.searchTransactions(customerId); 
	}

}
