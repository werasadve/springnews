package com.newsapp.SpringNews.Repo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.newsapp.SpringNews.Entity.News;

@Repository
public class NewsRepository {
	
	private static List<News> news;
	
	static{
		news = Collections.synchronizedList(new ArrayList<>());	
		//fake data
		news.add(new News(1, 2, "US bombers fly over Korean Peninsula in response to N. Korea's ICBM test", "For the second time in two days, US Air Force bombers put on a show of force in East Asia.B-1 Lancer bombers from Guam flew over the Korean Peninsula Friday in response to North Korea's increasing ballistic missile and nuclear threat, according to the US Pacific Air Forces.", "admin", "01.07.2017.", "12:15"));
		news.add(new News(2, 11, "Moto G5S Plus to feature improved camera, premium design", "Motorola has a press event scheduled towards the end of this month, and what we’re seeing here is sure to be one of the announcements: the new Moto G5S Plus. The device not just a special edition of the original G5 Plus, but an overall improvement with a number of key feature upgrades, including the camera, build quality, and display.", "admin", "05.07.2017.", "14:00"));
		news.add(new News(3, 7, "New Zealand v British and Irish Lions: Welsh fans react", "A long-range penalty from Owen Farrell snatched a late 12-12 draw for the Lions in an epic third Test at Eden Park in Auckland. Fans watching the game at Rhiwbina Recreation Club had mixed emotions after the game.But they lauded Lions captain Sam Warburton, who was a former player at the club.", "admin", "08.07.2017.", "16:23"));
		news.add(new News(4, 17, "Ubuntu is now available for download on the Windows Store", "Ubuntu — like SUSE Linux and Fedora, the other two forthcoming Linux distros heading to the store — runs in a sandbox alongside Windows 10, and offers regular command-line utilities as a standalone installation, with shared access to files and hardware with Windows 10.", "admin", "11.07.2017.", "12:28"));
	}
	
	public List<News> getAllNews(){
		return news;
	}
	
	public News getNewsById(int id){
		return news.stream().filter((n) -> n.getId() == id).findFirst().get();
	}
	
	public int getVote(int id){
		News nn = news.stream().filter((n) -> n.getId() == id).findFirst().get();
		return nn.getVotes();
	}
	
	public void remove(int id){
		news.removeIf((n) -> n.getId() == id);
	}
	
	public void addNews(News newn){
		news.add(newn);
	}
	
}
