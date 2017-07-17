<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ page import="java.sql.*" %>    
<%@ page import="javax.naming.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="work.model.dao.*" %>
<%@ page import="work.model.dto.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%
	try {
		MemberDao dao = new MemberDao();
		Member dto = dao.getUserInfo("user01");
		System.out.println("회원조회:" + dto);
	} catch(Exception e) {
		System.out.println(e.getMessage());
	}

%>
</body>
</html>