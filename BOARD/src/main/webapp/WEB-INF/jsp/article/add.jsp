<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.sbs.board.dto.Article"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 사이트 - 게시물 작성</title>
</head>
<body>
	<h1>게시물 작성</h1>
	<form action="./doAdd" method="POST" onsubmit="submitAddForm(this); return false;">
		<div>
			<span>
				제목
			</span>
			<div>
				<input type="text" placeholder="제목" autofocus="autofocus">
			</div>
		</div>
		
		<div>
			<span>
				내용
			</span>
			<div>
				<textarea placeholder="내용"></textarea>
			</div>
		</div>
</body>
</html>