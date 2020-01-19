package com.sbs.board.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	// beforeActionInterceptor 불러오는 작업
	@Autowired
	@Qualifier("beforeActionInterceptor")
	HandlerInterceptor beforeActionInterceptor;

	// needToLoginInterceptor 불러오는 작업
	@Autowired
	@Qualifier("needToLoginInterceptor")
	HandlerInterceptor needToLoginInterceptor;

	// needToLogoutInterceptor 불러오는 작업
	@Autowired
	@Qualifier("needToLogoutInterceptor")
	HandlerInterceptor needToLogoutInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// beforeActionInterceptor를 모든 액션(/**)에 연결한다.
		// 단 , resource로 시작하는 액션은 제외.
		registry.addInterceptor(beforeActionInterceptor).addPathPatterns("/**").excludePathPatterns("/resource/**");	
		
		//   (/**) 는 로그인 된 상태로만 접근이 가능한데,   (/resource/**) 와   member/login , member/doLogin/ , member/join , member/doJoin
		//  Home 은 비로그인으로도 접근이 가능하다 (예외)
		registry.addInterceptor(needToLoginInterceptor).addPathPatterns("/**").excludePathPatterns("/resource/**")
				.excludePathPatterns("/").excludePathPatterns("/member/login").excludePathPatterns("/member/doLogin")
				.excludePathPatterns("/member/join").excludePathPatterns("/member/doJoin");

	
		//로그아웃 상태에서는 member/login , doLogin ,  join , doJoin 만 접근 가능하다.
		registry.addInterceptor(needToLogoutInterceptor).addPathPatterns("/member/login")
						.addPathPatterns("/member/doLogin").addPathPatterns("/member/join").addPathPatterns("/member/doJoin");
	}
}