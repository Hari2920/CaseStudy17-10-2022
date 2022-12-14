package com.gl.rechargeApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gl.rechargeApp.bean.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
	
	@Query("select max(id) from Bill")
	public Long findMaxBillId();
}