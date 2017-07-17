<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
<a href="index.jsp">
<img src="logo.gif" onblur="시작페이지 이동">
</a>
<hr>

<!-- 로그인 후 메뉴 -->
<%
	if (request.getAttribute("message") != null) {
%>
	<h3>Message : <%= request.getAttribute("message") %></h3>
	<hr>
<%
	}
%>

<%
	// 인증 받지 않은 사용자는 로그인/회원가입후 이용하라고 페이지 이동
	// 사용자 인증은 세션유무 뿐만이 아니라 세션에 설정된 정보 유무에 따라서 체킹
	// 아이디, 등급이 null 이면 인증받지 않은 사용자이므로 오류페이지로 이동
	String memberId = (String)session.getAttribute("memberId");
	String grade = (String)session.getAttribute("grade");
	if (memberId == null || grade == null) {
		request.setAttribute("message", "로그인/회원가입 후 사용하시기 바랍니다.");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
		dispatcher.forward(request, response);	
		//response.sendRedirect("index.jsp");
	}
%>
<div class="menu_area" style="text-align:right;">
<a href="controller?action=logout">로그아웃</a>
<a href="controller?action=myInfo">내정보조회</a>
<a href="changePassword.jsp">암호변경</a>
<a href="controller?action=myInfoUpdate">내정보변경</a>

<!-- 관리자 메뉴 -->
<%
	if (grade.equals("A")) {
%>
	<a href="controller?action=getMemberAll">전체회원조회</a>
	<a href="#">공지관리</a>
<%
	}
%>
&nbsp;&nbsp;||
<%= session.getAttribute("memberId") %>님 [<%= session.getAttribute("grade") %>]
</div>
<hr>


<!-- content area -->
<div class="content_area" 
	style="text-align:center;height:450px;">
<h3>회원관리시스템(MMS) : 회원전용 서비스 시작 페이지</h3>
</div>
<hr>


<!-- footer area -->
<div class="footer_area" style="text-align:center;">
COPYRIGHT 2017 WORK. ALL RIGHTS RESERVED
</div>

</body>
</html>