<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="work.model.dto.*" %>
<%@ page import="work.model.dao.*" %>
<%@ page import="java.util.*" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- model(dao) �׽�Ʈ ������ -->
<h3>�����׽�Ʈ(UnitTest)</h3>
<%
	MemberDao dao = new MemberDao();
	Member dto = dao.selectOne("auser01");
	
	// ���� �ܼ� ��� ����
	System.out.println("\n### dto : " + dto);
	System.out.println("\n### dto : " + dao.loginCheck("auser01", "password01"));
	
	// ������ ��� ���� 
	out.println("\n### dto : " + dto);
%>
</body>
</html>














