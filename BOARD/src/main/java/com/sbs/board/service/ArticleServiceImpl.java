package com.sbs.board.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sbs.board.dto.Article;
@Service
public class ArticleServiceImpl implements ArticleService  {
	public List<Article> getList(){
		//가짜데이터.
		Article article1 = new Article(1,"2019","제목1","제목1");
		Article article2 = new Article(1,"2020","제목2","제목2");
		Article article3 = new Article(1,"2021","제목3","제목3");
		List<Article> list = new ArrayList<>();
		
		list.add(article1);
		list.add(article2);
		list.add(article3);
		return list;
	}
}
