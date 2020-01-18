package com.sbs.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.sbs.board.dto.Article;
@Mapper
public interface ArticleDao {
	public List<Article> getList();
	
	public long add(Map<String, Object> param);

	public int getTotalCount();


	public Article getOne(long id);

	public void delete(long id);

	public void modify(Map<String, Object> param);

	public void hitUp(long id);

	


}
