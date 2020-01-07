<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.sbs.board.dto.Article" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
List<Article> list = (List<Article>)request.getAttribute("list");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 사이트  - 게시물 리스트</title>
</head>
<body>
	<h2>v1</h2>
	<h1>게시물 리스트 입니다.</h1>

	<%
		for (int i=0; i<list.size(); i++) {
	%>
	<%
		Article article = list.get(i);
	%>
	<section>
		번호 : <%=article.getId() %>,
		제목: <%=article.getTitle() %>,
		내용: <%=article.getBody() %>,
		날짜 : <%=article.getRegDate() %>
	</section>
	<hr>
	<%
		}
	%>
	
	<!-- el문법을 사용하면, request.getAttribute 할 필요가 없다. -->
	<h2>v2</h2>
		<c:forEach items="${list}" var="article">
		<section>
		번호 : ${article.id}, 제목 :
		${article.title}, 내용 :
		${article.body},
		날짜 :
		${article.regDate}
		</section>
		<hr>
		</c:forEach>
<!-- el문법 -->
 ${list}
</body>
</html>