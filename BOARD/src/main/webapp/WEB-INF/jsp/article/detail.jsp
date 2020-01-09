<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.sbs.board.dto.Article" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 사이트  - 게시물 상세페이지</title>
</head>
<body>
	<h1>게시물 상세페이지</h1>
	<!-- el문법을 사용하면, request.getAttribute 할 필요가 없다. -->
		<section>
		번호 : ${article.id}, 제목 : ${article.title}
		</section>
		<hr>
		<a href="./list">게시물 리스트</a>
		<a href="./add">게시물 추가</a>
<!-- el문법 -->
</body>
</html>