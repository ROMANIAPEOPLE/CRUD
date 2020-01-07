package com.sbs.board.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbs.board.dao.ArticleDao;
import com.sbs.board.dto.Article;
@Service
public class ArticleServiceImpl implements ArticleService  {
	@Autowired
	ArticleDao articleDao;
	
	
	public List<Article> getList(){
		//가짜데이터.
		return articleDao.getList();
	}
}
