package com.sbs.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemberController {
	@RequestMapping("/member/join")
	public String showJoin() {
		return "member/join";
	}
	
}