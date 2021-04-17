package com.sma.app.daoLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.sma.app.entity.message;

@Service
public interface MessageDoa extends JpaRepository<message, Integer> {

	public message findByMid(int msg_id);

}
