package com.stl.transactions.service;

import java.util.List;

import com.stl.transactions.model.Transactions;

public interface TransactionsService {
	public Transactions fundTransfer(Transactions a); 
	
	public List<Transactions> getTransactions(int customerId);
}
