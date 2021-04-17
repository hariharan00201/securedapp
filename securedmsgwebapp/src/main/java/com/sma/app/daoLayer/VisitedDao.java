package com.sma.app.daoLayer;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.sma.app.entity.visited;

@Service
public interface VisitedDao extends JpaRepository<visited, Integer> {

	
	public ArrayList<visited> findAllById(int uid);

	public ArrayList<visited> findAllByIdAndVisit(int uid, int i);
	
}
