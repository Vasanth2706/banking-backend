package com.stl.transactions.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stl.transactions.model.Transactions;

import jakarta.transaction.Transactional;

@Transactional
public interface TransactionsDao extends JpaRepository<Transactions,Integer>{
	
	@Query(value="Select * from transactions where customer_id=?1",nativeQuery=true)
	public List<Transactions> searchTransactions(int customerId);
}
