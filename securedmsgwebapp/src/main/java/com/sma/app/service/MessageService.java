package com.sma.app.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sma.app.daoLayer.MessageDoa;
import com.sma.app.daoLayer.VisitedDao;
import com.sma.app.entity.Inbox;
import com.sma.app.entity.message;
import com.sma.app.entity.visited;

@Component
public class MessageService {

	@Autowired
	VisitedService vs;
	@Autowired
	MessageDoa md;
	@Autowired
	UserService us;
	
	
	public ArrayList<Inbox> getMessage(int uid, int in) 
	{
	
		ArrayList<visited> l=vs.findAllById(uid,in);
		
		
		
		ArrayList<Inbox> res=new ArrayList<>();
		for(visited a : l)
		{
				message msg=md.findByMid(a.getMid());
				String name=us.getUname(msg.getFromid());
				Inbox i=new Inbox(msg.getMessage(),name,msg.getTime().toString().substring(10,19),msg.getTime().toString().substring(0,10),msg.getMid());
				res.add(i);
		}
		
		
		return res;
	}


	public Inbox getInboxMsgForThatMid(int mid) {
		
		message msg=md.findByMid(mid);
		String name=us.getUname(msg.getFromid());
		Inbox i=new Inbox(msg.getMessage(),name,msg.getTime().toString().substring(10,19),msg.getTime().toString().substring(0,10),msg.getMid());
		
		return i;
	}


	public void addMessage(message msg) {
		
		md.save(msg);
		
	}




}


