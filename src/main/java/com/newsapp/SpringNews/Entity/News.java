package com.newsapp.SpringNews.Entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class News {
	
	private int id;
	private int votes;
	@NotNull
	@Size(min=10,max=100)
	private String title;
	@NotNull
	@Size(min=30,max=600)
	private String content;
	private String author;
	private String date;
	private String time;
	private int color;
	
	public News() {}	
	
	public News(int id, int votes, String title, String content, String author, String date, String time) {
		this.id = id;
		this.votes = votes;
		this.title = title;
		this.content = content;
		this.author = author;
		this.date = date;
		this.time = time;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
