package com.stl.account.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stl.account.model.TPTAccount;


public interface TPTAccountDao extends JpaRepository<TPTAccount,Integer>{
	
	@Query(value="Select * from third_party_accounts where customer_Id=?1",nativeQuery=true)
	public List<TPTAccount> searchByCustomerId(int userid);
}
