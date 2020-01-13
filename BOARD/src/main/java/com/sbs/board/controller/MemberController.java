package com.sbs.board.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbs.board.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/member/join")
	public String showJoin() {
		return "member/join";
	}
	
	@RequestMapping("/member/doJoin")
	@ResponseBody
	public Map<String, Object> doJoin(@RequestParam Map<String, Object> param) {
	
		Map<String, Object> checkLoginIdDupRs=memberService.checkLoginIdDup((String)param.get("loginId"));//ID 중복체크
		
		return checkLoginIdDupRs;
	}
	
}