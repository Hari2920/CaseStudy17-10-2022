package com.gl.rechargeApp.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.rechargeApp.bean.MyUsers;

@Repository
public interface UsersRepository extends JpaRepository<MyUsers, String> {
Optional<MyUsers> findUserByUsername(String username); 
	
}

