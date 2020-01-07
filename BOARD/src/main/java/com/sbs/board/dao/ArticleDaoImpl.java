package com.sbs.board.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sbs.board.dto.Article;

@Component // 이렇게 해야 AutoWired에 의한 연결에 적용됨.
public class ArticleDaoImpl implements ArticleDao {
	public List<Article> getList(){
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
