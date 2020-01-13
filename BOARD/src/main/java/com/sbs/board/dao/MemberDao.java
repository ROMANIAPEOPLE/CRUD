package com.sbs.board.dao;

import org.apache.ibatis.annotations.Mapper;

import com.sbs.board.dto.Members;

@Mapper
public interface MemberDao {


	public int getLoginIdDupCount(String loginId);

}
