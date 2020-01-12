<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.sbs.board.dto.Article"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageName" value="회원가입" />
<%@ include file="../part/head.jspf"%>
<script>
		function submitJoinForm(form){
		form.loginId.value = form.loginId.value.trim();
		if(form.loginId.value == 0){
			alert('로그인ID를 입력해주세요.');
			form.loginId.focus();
		
			return false;
		}

		form.loginPw.value = form.loginPw.value.trim();
		if(form.loginPw.value == 0){
			alert('로그인PW를 입력해주세요.');
			form.loginPw.focus();
		
			return false;
		}

		form.loginPwConfirm.value = form.loginPwConfirm.value.trim();
		if(form.loginPwConfirm.value == 0){
			alert('로그인PW확인란을 입력해주세요.');
			form.loginPwConfirm.focus();
		
			return false;
		}

		form.submit();
	}
</script>
<form class="con common-form" action="./doAdd" method="POST"
	onsubmit="submitJoinForm(this); return false;">
	<div>
		<span>로그인ID</span>
		<div>
			<input type="text" name="loginId" placeholder="ID를 입력하세요."
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
			<input type="submit" value="작성"> <input type="reset"
				value="취소" onclick="history.back()">
		</div>
	</div>
</form>

<div class="btns con">
	<a href="/article/list">메인</a>
</div>
<!-- el문법 -->
<%@ include file="../part/foot.jspf"%>