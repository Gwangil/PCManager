<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="work.model.dto.Member" %>
    
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
<img src="logo.gif" onblur="���������� �̵�">
</a>
<hr>

<!-- �α��� �� �޴� -->
<%
	if (request.getAttribute("message") != null) {
%>
	<h3>Message : <%= request.getAttribute("message") %></h3>
	<hr>
<%
	}
%>

<%
	// ���� ���� ���� ����ڴ� �α���/ȸ�������� �̿��϶�� ������ �̵�
	// ����� ������ �������� �Ӹ��� �ƴ϶� ���ǿ� ������ ���� ������ ���� üŷ
	// ���̵�, ����� null �̸� �������� ���� ������̹Ƿ� ������������ �̵�
	String memberId = (String)session.getAttribute("memberId");
	String grade = (String)session.getAttribute("grade");
	if (memberId == null || grade == null) {
		request.setAttribute("message", "�α���/ȸ������ �� ����Ͻñ� �ٶ��ϴ�.");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
		dispatcher.forward(request, response);	
		//response.sendRedirect("index.jsp");
	}
%>
<div class="menu_area" style="text-align:right;">
<a href="controller?action=logout">�α׾ƿ�</a>
<a href="controller?action=myInfo">��������ȸ</a>
<a href="changePassword.jsp">��ȣ����</a>
<a href="controller?action=myInfoUpdate">����������</a>

<!-- ������ �޴� -->
<%
	if (grade.equals("A")) {
%>
	<a href="controller?action=getMemberAll">��üȸ����ȸ</a>
	<a href="#">��������</a>
<%
	}
%>

&nbsp;&nbsp;||
<%= session.getAttribute("memberId") %>�� [<%= session.getAttribute("grade") %>]
</div>
<hr>


<!-- content area -->
<h3>������</h3>
<%
	// ������ ���� ������ ��������
	Member dto = (Member)request.getAttribute("dto");
%>
<table border="1">
	<tr>
		<th>���̵�</th>
		<td><%= dto.getMemberId() %></td>
	</tr>
	
	<tr>
		<th>��й�ȣ</th>
		<td><%= dto.getMemberPw() %></td>
	</tr>
	
	<tr>
		<th>�̸�</th>
		<td><%= dto.getMemberName() %></td>
	</tr>
	
	<tr>
		<th>����ó</th>
		<td>
		<%= dto.getMobile() %>
		</td>
	</tr>

	<tr>
		<th>�̸���</th>
		<td>
		<%= dto.getEmail() %>
		</td>
	</tr>
	
	<tr>
		<th>������</th>
		<td><%= dto.getEntryDate() %></td>
	</tr>
	
	<tr>
		<th>���</th>
		<td><%= dto.getGrade() %></td>
	</tr>
	
	<tr>
		<th>���ϸ���</th>
		<td><%= dto.getMileage() %></td>
	</tr>
	
	<tr>
		<th>�����</th>
		<td><%= dto.getManager() %></td>
	</tr>
	
</table>

<!-- footer area -->
<div class="footer_area" style="text-align:center;">
COPYRIGHT 2017 WORK. ALL RIGHTS RESERVED
</div>

</body>
</html>