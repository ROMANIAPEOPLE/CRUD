package com.sbs.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Members {
	private long id;
	private String regDate;
	private String loginId;
	private String loginPw;

}
