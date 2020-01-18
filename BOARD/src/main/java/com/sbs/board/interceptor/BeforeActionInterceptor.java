package com.sbs.board.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.sbs.board.dto.Members;
import com.sbs.board.service.MemberService;

//BeforeActionInterceptor : 모든 액션 수행 전에 필수정보를 미리 세팅
//필수정보: 로그인 유무, 로그인 한 회원의 정보

@Component("beforeActionInterceptor") //컴포넌트 이름 설정
public class BeforeActionInterceptor implements HandlerInterceptor {
	
	@Autowired
	MemberService memberService;
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
			throws Exception {
		
		boolean isLogined  = false;
		long loginedMemberId  = 0;
		Members loginedMember = null;
		
		HttpSession session = request.getSession();
		
		
		if( session.getAttribute("loginedMemberId") !=null) {
			isLogined = true; //세션에 로그인 정보가 저장되어있다면 ? true
			loginedMemberId = (long) session.getAttribute("loginedMemberId");
			loginedMember = memberService.getOne(loginedMemberId);
			//id값에 해당하는 loginId와 pw를 가져온다.
		}
		
		
		request.setAttribute("isLogined", isLogined);
		request.setAttribute("loginedMemberId", loginedMemberId);
		request.setAttribute("loginedMember", loginedMember);
		
		
		request.setAttribute("testNumber", 1);
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
