package com.newsapp.SpringNews.Entity;

public class Votes {

	private int id;
	private String user;
	private int f;
	
	public Votes(int id, String user, int f) {
		this.id = id;
		this.user = user;
		this.f = f;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public int getF() {
		return f;
	}
	public void setF(int f) {
		this.f = f;
	}
	
}
