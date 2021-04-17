package com.sma.app.entity;

import java.sql.Timestamp;

public class Inbox {
	
	private String msg;
	private String from_user;
	private String time;
	private String date;
	private int mid;
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getFrom_user() {
		return from_user;
	}
	public void setFrom_user(String from_user) {
		this.from_user = from_user;
	}
	public Inbox() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Inbox(String msg, String from_user, String time,String date,int mid) {
		super();
		this.msg = msg;
		this.from_user = from_user;
		this.time = time;
		this.date=date;
		this.mid=mid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
