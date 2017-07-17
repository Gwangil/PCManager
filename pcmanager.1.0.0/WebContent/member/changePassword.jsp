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
<h3>��ȣ����</h3>
<form action="controller?action=changePassword" method="post">
	������ȣ : <input type="text" name="memberPw"><br>
	�����ȣ : <input type="text" name="newMemberPw"><br>
	<input type="submit" value="��ȣ����">
</form>
</body>
</html>















