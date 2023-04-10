package com.stl.account.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stl.account.model.Account;

import jakarta.transaction.Transactional;


@Repository
@Transactional
public interface AccountsDao extends JpaRepository<Account,Integer>{
	
	@Query(value="Select * from customers where account_id=?1",nativeQuery=true)
	public List<Account> searchByAccountId(int userid);
	
    @Modifying
    @Query(value="Update customers SET first_name=:first_name,last_name=:last_name,email=:email,phone=:phone,ifsc_code=:ifsc_code WHERE customer_id=:id",nativeQuery=true)
    public int updateTitle(@Param("id") int id, @Param("first_name") String first_name,
    		@Param("last_name") String last_name,
    		@Param("email") String email,
    		@Param("phone") String phone,
    		@Param("ifsc_code") String ifsc_code);
}
