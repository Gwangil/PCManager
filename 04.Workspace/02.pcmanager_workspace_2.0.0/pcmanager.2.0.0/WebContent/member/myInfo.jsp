<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="work.model.dto.Member" %>
<!-- jstl cofing -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<!-- external css : css/common.css -->
<link type="text/css" rel="stylesheet" href="css/common.css">

</head>
<body>

<!-- header area -->
<!-- logo link -->
<a href="/pcm/index.jsp">
<img src="/pcm/img/logo.gif" title="홈페이지 이동">
</a>
<hr>

<!-- 메세지 출력  -->
<c:if test="${not empty requestScope.message}">
	<h3>Message : <%= request.getAttribute("message") %></h3>
	<hr>
</c:if>

<!-- 로그인 후 메뉴 -->
<div class="menu_area" style="text-align:right;">
	<c:choose>
	<c:when test="${not empty sessionScope.memberId and 
		not empty sessionScope.grade}">
		${sessionScope.memberId}님[${sessionScope.grade}]&nbsp;
		<a href="/pcm/controller?action=logout">로그아웃</a>&nbsp;|&nbsp;
		<a href="/pcm/controller?action=myInfo">내정보조회</a>&nbsp;|&nbsp;
		<a href="changePassword.jsp">암호변경</a>&nbsp;|&nbsp;
		<a href="/pcm/controller?action=myInfoUpdate">내정보변경</a>&nbsp;|&nbsp;
		<a href="/pcm/controller?action=deleteMember">탈퇴</a>&nbsp;|&nbsp;
		
		<!-- 관리자 메뉴 -->
		<c:if test="${sessionScope.grade == 'A'}">
			[관리자]
			<a href="/pcm/controller?action=getMemberAll">전체회원조회</a>
			<a href="/pcm/controller?action=noticeInput">공지관리</a>
		</c:if>
	</c:when>
	
	<c:when test="${empty sessionScope.memberId or 
		empty sessionScope.grade}">
		<c:set var="message" value="로그인/회원가입 후 사용하시기 바랍니다." />
		<jsp:forward page="/pcm/error.jsp" />
	</c:when>
	</c:choose>
</div>
<hr>

<!-- content area -->
<h3>내정보</h3>
<table border="1">
	<tr>
		<th>아이디</th>
		<td>${requestScope.dto.memberId}</td>
	</tr>
	
	<tr>
		<th>비밀번호</th>
		<td>${requestScope.dto.memberPw}</td>
	</tr>
	
	<tr>
		<th>이름</th>
		<td>${requestScope.dto.memberName}</td>
	</tr>
	
	<tr>
		<th>성별</th>
		<td>${requestScope.dto.gender}</td>
	</tr>
	
	<tr>
		<th>생년월일</th>
		<td>${requestScope.dto.birthDate}</td>
	</tr>
	
	<tr>
		<th>이메일</th>
		<td>${requestScope.dto.email}</td>
	</tr>
	
	<tr>
		<th>연락처</th>
		<td>${requestScope.dto.mobile}</td>
	</tr>

	<tr>
		<th>주소</th>
		<td>${requestScope.dto.address}</td>
	</tr>
	
	<tr>
		<th>가입일</th>
		<td>${requestScope.dto.entryDate}</td>
	</tr>
	
	<tr>
		<th>등급</th>
		<td>${requestScope.dto.grade}</td>
	</tr>
	
	<c:choose>
		<c:when test='${requestScope.dto.grade == "G"}'>
			<tr>
				<th>마일리지</th>
				<td>${requestScope.dto.mileage}</td>
			</tr>
		</c:when>
		
		<c:when test='${requestScope.dto.grade == "S"}'>
			<tr>
				<th>담당자</th>
				<td>${requestScope.dto.manager}</td>
			</tr>
		</c:when>
	</c:choose>
	
</table>


<!-- footer area -->
<hr>
<div class="footer_area" style="text-align:center;">
COPYRIGHT 2017 WORK. ALL RIGHTS RESERVED
</div>

</body>
</html>