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


//	public int getTotalCount();


}
