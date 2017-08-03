package com.newsapp.SpringNews.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.newsapp.SpringNews.Entity.News;
import com.newsapp.SpringNews.Repo.NewsRepository;


@Service
public class NewsService {
	
	@Autowired
	private NewsRepository newsRepository;
	
	private int num = 4;
	
	public List<News> getAllNews(){
		newsRepository.getAllNews().sort((n1, n2) -> n2.getId() - n1.getId());
		return newsRepository.getAllNews();
	}
	
	public int upvote(int id){
		News n = newsRepository.getNewsById(id);
		n.setVotes(n.getVotes() + 1);
		return n.getVotes();
	}
	
	public int downvote(int id){
		News n = newsRepository.getNewsById(id);
		n.setVotes(n.getVotes() - 1);
		return n.getVotes();
	}
	
	public News getNewsById(int id){
		return newsRepository.getNewsById(id);
	}
	
	public void removeNewsById(int id){
		newsRepository.remove(id);
	}
	
	public int getVotes(int id){
		return newsRepository.getVote(id);
	}		
	
	public void addNews(News newn, String name){
		newn.setId(++num);
		newn.setAuthor(name);
		DateTimeFormatter formater1 = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		newn.setDate(LocalDate.now().format(formater1));
		DateTimeFormatter formater2 = DateTimeFormatter.ofPattern("HH:mm");
		newn.setTime(LocalTime.now(ZoneId.of("Europe/Zagreb")).format(formater2));
		newsRepository.addNews(newn);
	}

}
