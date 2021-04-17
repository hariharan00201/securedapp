package com.sma.app.daoLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.sma.app.entity.miners;


@Service
public interface MinerDao extends JpaRepository<miners, Integer>{
	
	
	public miners findByUname(String uname);
	public miners findById(int id);
	
}
