package com.sbs.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sbs.board.dto.Members;
import com.sbs.board.service.MemberService;

@Controller
public class HomeController {
	@Autowired
	MemberService memberService;

	@RequestMapping("/home/main")
	public String showMain(Model model) {
		return "/home/main";
	}

	@RequestMapping("/")
	public String showMain2() {
		return "redirect:/home/main";

	}

}
