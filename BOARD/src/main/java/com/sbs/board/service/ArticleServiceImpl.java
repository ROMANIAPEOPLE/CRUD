package com.sbs.board.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sbs.board.dao.ArticleDao;
import com.sbs.board.dto.Article;
import com.sbs.board.util.CUtil;
@Service
public class ArticleServiceImpl implements ArticleService  {
	@Autowired
	ArticleDao articleDao;
	
	@Override
	public List<Article> getList(){
		//가짜데이터
		return articleDao.getList();
	}

	@Override
	public long add(Map<String, Object> param) {
		articleDao.add(param);
		return CUtil.getAsLong(param.get("id"));
	}

	@Override
	public int getTotalCount() {
		return articleDao.getTotalCount();
	}
	
	@Override
	public Article getOne(long id) {
		return articleDao.getOne(id);
	}
}