package com.sbs.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sbs.board.dto.Article;
@Mapper
public interface ArticleDao {
	public List<Article> getList();
	

}
