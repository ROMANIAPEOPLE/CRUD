package com.sbs.board.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sbs.board.dto.Article;
import com.sbs.board.service.ArticleService;
import groovy.util.logging.Slf4j;

@Controller
@Slf4j // log.info 사용 , 디버깅 용도
public class ArticleController {
	@Autowired
	ArticleService articleService;
	
	@RequestMapping("/article/detail")
	public String showDetail(Model model, long id) {
		Article article = articleService.getOne(id);
		//특정 id값에 따른 list를 가져온다. 
		model.addAttribute("article", article);
		//뷰에 뿌려준다
		return "article/detail";
	}
	
	@RequestMapping("/article/list")
	public String showMain(Model model) {
		List<Article> list = articleService.getList();
		// list.jsp 에 뿌려질 게시글 리스트
		int totalCount = articleService.getTotalCount();
		//list.jsp 에 뿌려질 총 게시글 등록 수
		model.addAttribute("list", list);
		//뷰에 list를 뿌려줌
		model.addAttribute("totalCount", totalCount);
		//뷰에 totalCount를 뿌려줌
		return "article/list";
		
	}

	@RequestMapping("/article/add")
	// /article/add 가 요청되면  article/add로 이동
	public String showAdd() {
		return "article/add";
	}
	@RequestMapping("/article/doAdd")
	@ResponseBody
	public String doAdd(@RequestParam Map<String, Object> param) {
		//id 값을 제목과 내용을 추가할 때, 함께 가져와서 newId에 저장한다.
		long newId = articleService.add(param);
		String msg = newId + "번 게시물이 추가되었습니다.";
		StringBuilder sb = new StringBuilder();
		sb.append("alert('" + msg + "');"); // msg 팝업창을 띄운다.
		sb.append("location.replace('./detail?id=" + newId + "');");
		//location.replace를 통해 현재 창을  detail?newId 로 대체한다.
		sb.insert(0, "<script>");
		sb.append("</script>");
		return sb.toString();
	}
	
	@RequestMapping("/article/doDelete")
	@ResponseBody
	public String doAdd(long id) {
		//id 값을 제목과 내용을 추가할 때, 함께 가져와서 newId에 저장한다.
		long newId = articleService.delete(id);
		
		String msg = id + "번 게시물이 삭제되었습니다.";
		StringBuilder sb = new StringBuilder();
		sb.append("alert('" + msg + "');"); // msg 팝업창을 띄운다.
		sb.append("location.replace('./detail?id=" + newId + "');");
		//location.replace를 통해 현재 창을  detail?newId 로 대체한다.
		sb.insert(0, "<script>");
		sb.append("</script>");
		return sb.toString();
	}
	
}