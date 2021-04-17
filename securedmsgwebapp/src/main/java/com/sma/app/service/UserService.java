package com.sma.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sma.app.daoLayer.MinerDao;
import com.sma.app.entity.miners;


@Component
public class UserService {


	@Autowired
	MinerDao ld;
	
	public boolean checkLogin(String uname , String pass)
	{
		miners l=ld.findByUname(uname);
		if(l == null)
			return false;
			if(l.getUname().equals(uname) && l.getPass().equals(pass))
			{
				System.out.println("2");
				return true;
			}

		return false;
	}
	
	
	public void addMiner(miners m)
	{
		ld.save(m);
	}

	
	public boolean alreadyUser(String uname)
	{
		if(ld.findByUname(uname) != null)
			return true;
		return false;
	}


	public boolean checkCode(List<String> l, String attribute) {
		
		miners m=ld.findByUname(attribute);
		System.out.println(m.getUname());
		if(m.getWord1().equals(l.get(0)) && m.getWord2().equals(l.get(1)) && m.getWord3().equals(l.get(2)) && m.getWord4().equals(l.get(3)) && m.getWord5().equals(l.get(4)) && m.getWord6().equals(l.get(5))  && m.getWord7().equals(l.get(6))  && m.getWord8().equals(l.get(7))  && m.getWord9().equals(l.get(8))  && m.getWord10().equals(l.get(9)))
				return true;
		return false;
	}


	public int getId(String uname) {
		
		return ld.findByUname(uname).getId();
		
	}


	public String getUname(int fromid) {
		
		miners m=ld.findById(fromid);
		return m.getUname();
	}
}
