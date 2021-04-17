package com.sma.app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class visited {

	@Id
	private int mid;
	private int visit;
	private int id;
	
	
	public visited(int msg_id, int visit, int id) {
		super();
		this.mid = msg_id;
		this.visit = visit;
		this.id = id;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int msg_id) {
		this.mid = msg_id;
	}
	public int getVisit() {
		return visit;
	}
	public void setVisit(int visit) {
		this.visit = visit;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public visited() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
