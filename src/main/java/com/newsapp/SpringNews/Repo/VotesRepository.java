package com.newsapp.SpringNews.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.newsapp.SpringNews.Entity.Votes;

@Repository
public interface VotesRepository extends JpaRepository<Votes, Integer>{
	
	Votes findByIdAndUser(int id, String user);
	
	List<Votes> findById(int id);
	
}
