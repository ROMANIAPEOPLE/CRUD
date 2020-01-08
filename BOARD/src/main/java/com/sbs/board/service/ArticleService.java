package com.sbs.board.service;

import java.util.List;
import java.util.Map;

import com.sbs.board.dto.Article;

public interface ArticleService {

	public List<Article> getList();

	public long add(Map<String, Object> param);
}
