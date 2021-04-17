package com.sma.app.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class message {

	@Id
	private int mid;
	private int id;
	private String message;
	private int fromid;
	
	//@Temporal(TemporalType.TIMESTAMP)
	private Timestamp time;


	
	
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getFromid() {
		return fromid;
	}
	public void setFromid(int fromid) {
		this.fromid = fromid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public message(int id, String msg, int from_id) {
		super();
		//this.mid = msg_id;
		this.id = id;
		this.message = msg;
		this.fromid = from_id;
		this.time=new java.sql.Timestamp(new java.util.Date().getTime());
	}
	public void setId(int id) {
		this.id = id;
	}
	public message() {
		super();
		// TODO Auto-generated constructor stub
	}

}
