package com.newsapp.SpringNews.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newsapp.SpringNews.Controller.ViewController;
import com.newsapp.SpringNews.Entity.News;
import com.newsapp.SpringNews.Repo.NewsRepository;
import com.newsapp.SpringNews.Repo.VotesRepository;


@Service
public class NewsService {
	
	@Autowired
	private NewsRepository newsRepository;
	
	@Autowired
	private VotesRepository votesRepository;
	
	private long deletedId;
	
	public List<News> getAllNews(){
		List<News> n = newsRepository.findAll();
		n.sort((n1, n2) -> n2.getId() - n1.getId());
		return n;
	}
	
	public int upvote(int id){
		News n = newsRepository.findOne(id);
		n.setVotes(n.getVotes() + 1);
		newsRepository.save(n);
		return n.getVotes();
	}
	
	public int downvote(int id){
		News n = newsRepository.findOne(id);
		n.setVotes(n.getVotes() - 1);
		newsRepository.save(n);
		return n.getVotes();
	}
	
	public News getNewsById(int id){
		return newsRepository.findOne(id);
	}
	
	@Transactional
	public void removeNewsById(int id){
		newsRepository.delete(id);
		votesRepository.findByNewsId(id).stream().forEach(v -> votesRepository.delete(v.getId()));
		deletedId = id;
	}
	
	public int getVotes(int id){
		return newsRepository.findOne(id).getVotes();
	}		
	
	public void addNews(News newn, String name){
		newn.setAuthor(name);
		DateTimeFormatter formater1 = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		newn.setDate(LocalDate.now().format(formater1));
		DateTimeFormatter formater2 = DateTimeFormatter.ofPattern("HH:mm");
		newn.setTime(LocalTime.now(ZoneId.of("Europe/Zagreb")).format(formater2));
		newsRepository.save(newn);
	}
	
	public long getDeletedId(){
		return deletedId;
	}

}
