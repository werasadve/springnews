package com.newsapp.SpringNews.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.newsapp.SpringNews.Entity.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer>{

	List<News> findAllByOrderByIdDesc();
	
}
