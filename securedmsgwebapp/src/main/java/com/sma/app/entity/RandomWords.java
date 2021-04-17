package com.sma.app.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;


@Component
public class RandomWords {
	
	
	List<String> randomlist=Arrays.asList("banana","peach","jam","mastiff","gillete","army","apple","men","women","basin","project","horn","honey","warning","wind","blow","wow","fire","forest","head","body");
	
	public ArrayList<String> returnRandomWords()
	{
		ArrayList<String> res=new ArrayList<>();
		Set<Integer> ha=new HashSet<>();
		for(int i=0;i<10;)
		{
			int a=(int) (Math.random()*randomlist.size());
			if(!ha.contains(a))
			{
				ha.add(a);
				res.add(randomlist.get(a));
				i++;
			}
		}
		return res;
	}
}
