package com.sma.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sma.app.daoLayer.VisitedDao;
import com.sma.app.entity.visited;

@Component
public class VisitedService {

	@Autowired
	VisitedDao vd;
	@Autowired
	UserService us;

	public void removeFromVisited(int mid, String string) {
		vd.save(new visited(mid,2,us.getId(string)));
		
	}

	public ArrayList<visited> findAllById(int uid, int in) {
		
		return vd.findAllByIdAndVisit(uid,in);
		
	}
	
	
	
}
