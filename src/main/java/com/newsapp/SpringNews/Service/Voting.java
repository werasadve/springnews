package com.newsapp.SpringNews.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newsapp.SpringNews.Entity.News;
import com.newsapp.SpringNews.Entity.Votes;
import com.newsapp.SpringNews.Repo.VotesRepository;

@Service
public class Voting {
	
	@Autowired
	NewsService newsService;
	
	@Autowired
	VotesRepository votesRepository;
	
	public String upvote(int id, String user){
		Votes vote = votesRepository.getVoteByIdAndUser(id, user);
		if(vote == null){
			votesRepository.add(new Votes(id, user, 1));
			newsService.upvote(id);
		}
		else{
			switch(vote.getF()){
			case 1:
				newsService.downvote(id);
				vote.setF(0);
				break;
			case 0:
				newsService.upvote(id);
				vote.setF(1);
				break;
			case -1:
				newsService.upvote(id);
				newsService.upvote(id);
				vote.setF(1);
				break;
			}
			
		}
		return newsService.getVotes(id) + "," + (vote != null ? vote.getF() : 1);
	}
	
	public String downvote(int id, String user){
		Votes vote = votesRepository.getVoteByIdAndUser(id, user);
		if(vote == null){
			votesRepository.add(new Votes(id, user, -1));
			newsService.downvote(id);
		}
		else{
			switch(vote.getF()){
			case 1:
				newsService.downvote(id);
				newsService.downvote(id);
				vote.setF(-1);
				break;
			case 0:
				newsService.downvote(id);
				vote.setF(-1);
				break;
			case -1:
				newsService.upvote(id);
				vote.setF(0);
				break;
			}
		}
		return newsService.getVotes(id) + "," + (vote != null ? vote.getF() : -1);
	}	
	
	public void setColors(String user){
		List<Votes> votes = votesRepository.getAllVotes().stream().filter((u) -> u.getUser().equals(user)).collect(Collectors.toList());   
		for(News n : newsService.getAllNews()){
			n.setColor(0);
			for(Votes v : votes)
				if(n.getId() == v.getId())
					n.setColor(v.getF());
		}
	}

}
