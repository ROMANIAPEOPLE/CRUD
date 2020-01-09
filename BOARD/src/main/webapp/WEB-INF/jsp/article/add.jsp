<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.sbs.board.dto.Article"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<style>
.con {
	width: 1000px;
	margin: 0 auto;
}

.common-form>div>* {
	float: left;
}

.common-form>div::after {
	content: "";
	display: block;
	clear: both;
}

.common-form>div>span {
	background-color: yellow;
	width: 50px;
}

.common-form>div>div {
	width: calc(100% - 50px);
}

.common-form>div>div>textarea {
	width: 90%;
}
</style>


<meta charset="UTF-8">
<title>커뮤니티 사이트 - 게시물 작성</title>
</head>
<body>

	<script>
		function submitAddForm(form){
		form.title.value = form.title.value.trim();
		if(form.title.value == 0){
			alert('제목을 입력해주세요.');
			form.title.focus();
		
			return false;
			}
			form.submit();
		}


		function submitAddForm(form){
			form.body.value = form.body.value.trim();
			if(form.body.value == 0){
				alert('내용을 입력해주세요.');
				form.body.focus();
			
				return false;
				}
				form.submit();
			}
		
		</script>
	<h1>게시물 작성</h1>
	<form class="con common-form" action="./doAdd" method="POST"
		onsubmit="submitAddForm(this); return false;">
		<div>
			<span> 제목 </span>
			<div>
				<input type="text" name="title" placeholder="제목"
					autofocus="autofocus">
			</div>
		</div>

		<div>
			<span> 내용 </span>
			<div>
				<textarea name="body" placeholder="내용"></textarea>
			</div>
		</div>

		<div>
			<span> 작성 </span>
			<div>
				<input type="submit" value="작성"> 
				<input type="reset"	value="취소" onclick="history.back()">
			</div>
		</div>
	</form>
</body>
</html>