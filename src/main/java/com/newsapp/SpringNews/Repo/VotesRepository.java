package com.newsapp.SpringNews.Repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.newsapp.SpringNews.Entity.Votes;
import com.newsapp.SpringNews.Service.NewsService;


@Repository
public class VotesRepository {

	private static List<Votes> votes;
	
	@Autowired
	NewsService newsService;
	
	static{
		votes = new ArrayList<>();
	}
	
	public List<Votes> getAllVotes(){
		return votes;
	}
	
	public void add(Votes vote){
		votes.add(vote);
	}
	
	public Votes getVoteByIdAndUser(int id, String user){
		for(Votes v : votes)
			if(v.getId() == id && v.getUser() == user)
				return v;
		return null;
	}

}
