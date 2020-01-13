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

		if(form.loginPw.value != form.loginPwConfirm.value){
			alert('PW와 PW confirm이 일치하지 않습니다.')
			form.loginPwConfirm.focus();
			return false;
			}
		
		form.submit();
	}
</script>
<form class="con common-form" action="./doJoin" method="POST"
	onsubmit="submitJoinForm(this); return false;">
	<div>
		<span>ID</span>
		<div>
			<input type="text" name="loginId" placeholder="ID를 입력하세요."
				autofocus="autofocus">
		</div>
	</div>
	
	<div>
		<span>PW</span>
		<div>
			<input type="password" name="loginPw" placeholder="**********"
				autofocus="autofocus">
		</div>
	</div>
	
	<div>
		<span>PW confirm</span>
		<div>
			<input type=password name="loginPwConfirm" placeholder="**********"
				autofocus="autofocus">
		</div>
	</div>

	<div>
		<span>      　</span>
		<div>
			<input type="submit" value="가입">
			 <input type="reset" value="취소" >
		</div>
	</div>
</form>

<div class="btns con">
	<a href="/article/list">메인</a>
</div>
<!-- el문법 -->
<%@ include file="../part/foot.jspf"%>