package com.sbs.board.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.sbs.board.dto.Members;

@Mapper
public interface MemberDao {


	public int getLoginIdDupCount(String loginId);

	public void join(Map<String, Object> param);

	public Members getMatchedOne(String loginId, String loginPw);

	public Members getOne(long loginedMemberId);

}
