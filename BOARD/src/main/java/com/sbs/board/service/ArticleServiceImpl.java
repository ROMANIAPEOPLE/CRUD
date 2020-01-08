package com.sbs.board.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbs.board.dao.ArticleDao;
import com.sbs.board.dto.Article;
@Service
public class ArticleServiceImpl implements ArticleService  {
	@Autowired
	ArticleDao articleDao;
	
	@Override
	public List<Article> getList(){
		//가짜데이터.
		return articleDao.getList();
	}

	@Override
	public long add(Map<String, Object> param) {
		articleDao.add(param);

		BigInteger numId = (BigInteger)(param.get("id"));
		long newId = numId.longValue();
		return newId;
	
	}
	
	
}
