package com.sbs.board.service;

import java.util.Map;

import com.sbs.board.dto.Members;

public interface MemberService{

	public Map<String, Object> checkLoginIdDup(String loginId);
	
	public Map<String, Object> join(Map<String, Object> param);

	public Members getMatchedOne(String loginId, String loginPw);

	public Members getOne(long loginedMemberId);

	
		

}
