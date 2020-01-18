package com.sbs.board.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sbs.board.dto.Members;
import com.sbs.board.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/member/login")
	public String showLogin() {
		return "member/login";
	}

	@RequestMapping("/member/doLogout")
	public String doLogout(HttpSession session) {
		session.removeAttribute("loginedMemberId");
		//로그아웃하면 세션에 저장된 loginId정보를 세션에서 제거한다.
		return "redirect:/";
	}
	
	@RequestMapping("/member/doLogin")
	public String doLogin(@RequestParam Map<String, Object> param, Model model, HttpSession session) {
		Members matchedMember = memberService.getMatchedOne((String) param.get("loginId"),
				(String) param.get("loginPw"));
		//matchedMember 변수에  loginId와 loginPw 두 개의 정보가 일치하는 정보가 있는지 확인한다. 일치한다면 null이 아닌 값이 저장될것이다.

		if (matchedMember == null) {
			model.addAttribute("alertMsg", "일치하는 회원이 존재하지 않습니다.");
			model.addAttribute("historyBack", true);
			return "common/redirect";
			//DB에 저장되어있지 않은 id와pw정보가 입력되었다면 , 위와같은 얼럿창을 리턴한다.
			
		}

		session.setAttribute("loginedMemberId", matchedMember.getId());

		model.addAttribute("alertMsg", "로그인 되었습니다.");
		model.addAttribute("redirectUrl", "/");
		return "common/redirect";
	}
	
	
	@RequestMapping("/member/join")
	public String showJoin() {
		return "member/join";
	}
	
	@RequestMapping("/member/doJoin")
	public String doJoin(@RequestParam Map<String, Object> param, Model model) {
		// 로그인 ID의 중복성 체크
		Map<String, Object> checkLoginIdDupRs = memberService.checkLoginIdDup((String) param.get("loginId"));

		if (((String) checkLoginIdDupRs.get("resultCode")).startsWith("F-")) {
			model.addAttribute("alertMsg", checkLoginIdDupRs.get("msg"));
			model.addAttribute("historyBack", true);
			return "common/redirect";
		}

		Map<String, Object> joinRs = memberService.join(param);

		if (((String) joinRs.get("resultCode")).startsWith("F-")) {
			model.addAttribute("alertMsg", joinRs.get("msg"));
			model.addAttribute("historyBack", true);
			return "common/redirect";
		}

		model.addAttribute("alertMsg", joinRs.get("msg"));
		model.addAttribute("redirectUrl", "/member/login");

		return "common/redirect";
	}
	
}