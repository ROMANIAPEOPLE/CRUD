package com.sbs.board.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbs.board.dto.Members;
import com.sbs.board.service.MemberService;


@Controller
public class HomeController {
	@Autowired
	MemberService memberService;
	@RequestMapping("/home/main")
	public String showMain(HttpSession session) {
		long loginedMemberId =0;
		
		if( session.getAttribute("loginedMemberId") != null) {
			loginedMemberId = (long)session.getAttribute("loginedMemberId");
		}
		
	Members loginedMember=	memberService.getOne(loginedMemberId);
		
		return "/home/main";
	}
	
	@RequestMapping("/")
	public String showMain2() {
		return "redirect:/home/main";
		
	}
	
}
