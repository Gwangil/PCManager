<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="work.model.dao.*"%>
<%@ page import="work.model.dto.*"%>
<%@ page import="work.controller.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>좌성배정시스템</title>
<%
		SeatDao dao = new SeatDao();
		ArrayList<Seat> list = dao.selectList();
		int condition1 =list.get(0).getCondition();
		int condition2 =list.get(1).getCondition();
		int condition3 =list.get(2).getCondition();
		int condition4 =list.get(3).getCondition();
		int condition5 =list.get(4).getCondition();
		int condition6 =list.get(5).getCondition();
		int condition7 =list.get(6).getCondition();
		int condition8 =list.get(7).getCondition();
		int condition9 =list.get(8).getCondition();
		int condition10 =list.get(9).getCondition();
		int condition11 =list.get(10).getCondition();
		int condition12 =list.get(11).getCondition();
		int condition13 =list.get(12).getCondition();
		int condition14 =list.get(13).getCondition();
		int condition15 =list.get(14).getCondition();
		int condition16 =list.get(15).getCondition();
		int condition17 =list.get(16).getCondition();
		int condition18 =list.get(17).getCondition();
		int condition19 =list.get(18).getCondition();
		int condition20 =list.get(19).getCondition();
		int condition21 =list.get(20).getCondition();
		int condition22 =list.get(21).getCondition();
		int condition23 =list.get(22).getCondition();
		int condition24 =list.get(23).getCondition();
		int condition25 =list.get(24).getCondition();
		int condition26 =list.get(25).getCondition();
		int condition27 =list.get(26).getCondition();
		int condition28 =list.get(27).getCondition();
		int condition29 =list.get(28).getCondition();
		int condition30 =list.get(29).getCondition();

	%>

	<script type="text/javascript">
	function payCount1(){
		document.payForm.totalCost.value=1000;
		document.payForm.remainCost.value=1000;
	}
	function payCount2(){
		document.payForm.totalCost.value=2000;
		document.payForm.remainCost.value=2000;
	}
	function payCount3(){
		document.payForm.totalCost.value=3000;
		document.payForm.remainCost.value=3000;
	}
	function payCount5(){
		document.payForm.totalCost.value=5000;
		document.payForm.remainCost.value=5000;
	}
	function payCount8(){
		document.payForm.totalCost.value=8000;
		document.payForm.remainCost.value=8000;
	}
	function payCount10(){
		document.payForm.totalCost.value=10000;
		document.payForm.remainCost.value=10000;
	}
	
	function insertMoney(){
		
		var insertCost = Number(document.payForm.insertCost.value);
		insertCost+=1000;
		document.payForm.insertCost.value=insertCost;
		document.payForm.remainCost.value-=1000;
		if(document.payForm.remainCost.value==0){
			alert("결제버튼을 눌러주세요");
			document.getElementById("insert").disabled = true;
		}
	}
	
</script>
<link type="text/css" rel="stylesheet" href="css/common.css">
</head>
<body>
<h2 align="center">좌석배정시스템</h2><p>
<%
	int onNumber = dao.onNumber();
	int offNumber = dao.offNumber();
%>
<table width="1200px" border="1">
	<tr width="1200px">
		<td width="600px" align="center">사용가능좌석 : <%=onNumber%></td>
		<td width="600px" align="center">빈좌석 : <%=offNumber%></td>
	</tr>
</table>
<hr>
<form id="payForm" name="payForm" action="/pcm/seatcontroller?action=payCharge" method="post">

	<table width="1200px"  border="1" height="750px">
		<tr width= "1200px">
			<td align ="center" valign="middle" width="300">
						<table width="300" height="650" >
							<tr>
								<td colspan="2" height="50"></td>
							</tr>
							<tr>
								<td width="150px" height="150px" bordercolor="write"> 
									<IMG SRC="seatImg/cal01.jpg" align="center"  width="150px" height="150px" onclick ="payCount1()">
								</td>
								<td width="150px" height="150px" bordercolor="write"> 
									<IMG SRC="seatImg/cal02.jpg" align="center"  width="150px" height="150px" onclick="payCount2()">
								</td>
							</tr>
							<tr>
								<td colspan="2" height="50"></td>
							</tr>
							<tr>
								<td width="150px" height="150px" bordercolor="write"> 
									<IMG SRC="seatImg/cal03.jpg" align="center"  width="150px" height="150px"onclick="payCount3()">
								</td>
								<td width="150px" height="150px" bordercolor="write"> 
									<IMG SRC="seatImg/cal04.jpg" align="center"  width="150px" height="150px" onclick="payCount5()">
								</td>
							</tr>
							<tr>
								<td colspan="2" height="50"></td>
							</tr>
							<tr>
								<td width="150px" height="150px" bordercolor="write"> 
									<IMG SRC="seatImg/cal05.jpg" align="center"  width="150px",height="150px" onclick="payCount8()">
								</td>
								<td width="150px" height="150px" bordercolor="write"> 
									<IMG SRC="seatImg/cal06.jpg" align="center"  width="150px",height="150px" onclick="payCount10()">
								</td>
							</tr>
							<tr>
								<td colspan="2" height="50"></td>
							</tr>
									
						</table>
			</td>
			<td align ="center" valign="middle" width="300px">
				<table height="650px" width="300px">
					<tr  height="50px">
						<td>
							<h2  align="center" >결제화면</h2>
						</td>
					</tr>
					<tr>
						<td><h3>
							아이디 : <input type="text" id="memberId" name="memberId" value="아이디를입력하세요"><br>
							좌석번호 : <input type="text" id="seatNo" name="seatNo" value="좌석번호를 입력하세요"><br><br><br>
							투입금액 : <input type="text" id="insertCost" name="insertCost" readonly>  원<br><br>
							남은금액 : <input type="text" id="remainCost" name="remainCost" readonly> 원<br><br>
							총금액   : <input type="text" id="totalCost" name="totalCost" readonly> 원<br><br>
									<input type="button" value = "1000원투입" align="left" id="insert" onclick="insertMoney()">
						</h3><td>
					</tr>
					<tr>
						<td>
							 <input type="submit" value="결제" >
						<td>
					</tr>
				</table>
			</td>
			
			<!-- 좌석 -->
			<td align ="center" valign="middle" width="600px" height="650px">
			<table width="600px" height="650px" border="1">
				<tr>
				<td width="120px" height="113px">
					<%	if (list.get(0).getCondition() == 1) { %>
						<IMG SRC="seatImg/onseat01.jpg" id ="seat01" align="center"  width="120px" height="113px">
					<%	} else { %>
						<IMG SRC="seatImg/offseat01.jpg" id ="seat01" align="center"  width="120px" height="113px">
					<% 	} %>
				</td>
				<td width="120px" height="113px">
					<%	if (list.get(1).getCondition() == 1) { %>
						<IMG SRC="seatImg/onseat02.jpg" id ="seat02" align="center"  width="120px" height="113px">
					<%	} else { %>
						<IMG SRC="seatImg/offseat02.jpg" id ="seat02" align="center"  width="120px" height="113px">
					<% 	} %>
				</td>
				<td width="120px" height="113px">
					<%	if (list.get(2).getCondition() == 1) { %>
						<IMG SRC="seatImg/onseat03.jpg" id ="seat03" align="center"  width="120px" height="113px">
					<%	} else { %>
						<IMG SRC="seatImg/offseat03.jpg" id ="seat03" align="center"  width="120px" height="113px">
					<% 	} %>
				</td>
				<td width="120px" height="113px">
					<%	if (list.get(3).getCondition() == 1) { %>
						<IMG SRC="seatImg/onseat04.jpg" id ="seat04" align="center"  width="120px" height="113px">
					<%	} else { %>
						<IMG SRC="seatImg/offseat04.jpg" id ="seat04" align="center"  width="120px" height="113px">
					<% 	} %>
				</td>
				<td width="120px" height="113px">
					<%	if (list.get(4).getCondition() == 1) { %>
						<IMG SRC="seatImg/onseat05.jpg" id ="seat05" align="center"  width="120px" height="113px">
					<%	} else { %>
						<IMG SRC="seatImg/offseat05.jpg" id ="seat05" align="center"  width="120px" height="113px">
					<% 	} %>
				</td>
				</tr>
				
				<tr>
				<td width="120px" height="113px">
					<%	if (list.get(5).getCondition() == 1) { %>
						<IMG SRC="seatImg/onseat06.jpg" id ="seat06" align="center"  width="120px" height="113px">
					<%	} else { %>
						<IMG SRC="seatImg/offseat06.jpg" id ="seat06" align="center"  width="120px" height="113px">
					<% 	} %>
				</td>
				<td width="120px" height="113px">
					<%	if (list.get(6).getCondition() == 1) { %>
						<IMG SRC="seatImg/onseat07.jpg" id ="seat07" align="center"  width="120px" height="113px">
					<%	} else { %>
						<IMG SRC="seatImg/offseat07.jpg" id ="seat07" align="center"  width="120px" height="113px">
					<% 	} %>
				</td>
				<td width="120px" height="113px">
					<%	if (list.get(7).getCondition() == 1) { %>
						<IMG SRC="seatImg/onseat08.jpg" id ="seat08" align="center"  width="120px" height="113px">
					<%	} else { %>
						<IMG SRC="seatImg/offseat08.jpg" id ="seat08" align="center"  width="120px" height="113px">
					<% 	} %>
				</td>
				<td width="120px" height="113px">
					<%	if (list.get(8).getCondition() == 1) { %>
						<IMG SRC="seatImg/onseat09.jpg" id ="seat09" align="center"  width="120px" height="113px">
					<%	} else { %>
						<IMG SRC="seatImg/offseat09.jpg" id ="seat09" align="center"  width="120px" height="113px">
					<% 	} %>
				</td>
				<td width="120px" height="113px">
					<%	if (list.get(9).getCondition() == 1) { %>
						<IMG SRC="seatImg/onseat10.jpg" id ="seat10" align="center"  width="120px" height="113px">
					<%	} else { %>
						<IMG SRC="seatImg/offseat10.jpg" id ="seat10" align="center"  width="120px" height="113px">
					<% 	} %>
				</td>
				</tr>
				
				<tr>
				<td width="120px" height="113px">
					<%	if (list.get(10).getCondition() == 1) { %>
						<IMG SRC="seatImg/onseat11.jpg" id ="seat11" align="center"  width="120px" height="113px">
					<%	} else { %>
						<IMG SRC="seatImg/offseat11.jpg" id ="seat11" align="center"  width="120px" height="113px">
					<% 	} %>
				</td>
				<td width="120px" height="113px">
					<%	if (list.get(11).getCondition() == 1) { %>
						<IMG SRC="seatImg/onseat12.jpg" id ="seat12" align="center"  width="120px" height="113px">
					<%	} else { %>
						<IMG SRC="seatImg/offseat12.jpg" id ="seat12" align="center"  width="120px" height="113px">
					<% 	} %>
				</td>
				<td width="120px" height="113px">
					<%	if (list.get(12).getCondition() == 1) { %>
						<IMG SRC="seatImg/onseat1.jpg" id ="seat13" align="center"  width="120px" height="113px">
					<%	} else { %>
						<IMG SRC="seatImg/offseat13.jpg" id ="seat13" align="center"  width="120px" height="113px">
					<% 	} %>
				</td>
				<td width="120px" height="113px">
					<%	if (list.get(13).getCondition() == 1) { %>
						<IMG SRC="seatImg/onseat14.jpg" id ="seat14" align="center"  width="120px" height="113px">
					<%	} else { %>
						<IMG SRC="seatImg/offseat14.jpg" id ="seat14" align="center"  width="120px" height="113px">
					<% 	} %>
				</td>
				<td width="120px" height="113px">
					<%	if (list.get(14).getCondition() == 1) { %>
						<IMG SRC="seatImg/onseat15.jpg" id ="seat15" align="center"  width="120px" height="113px">
					<%	} else { %>
						<IMG SRC="seatImg/offseat15.jpg" id ="seat15" align="center"  width="120px" height="113px">
					<% 	} %>
				</td>
				</tr>
				
				<tr>
				<td width="120px" height="113px">
					<%	if (list.get(15).getCondition() == 1) { %>
						<IMG SRC="seatImg/onseat16.jpg" id ="seat16" align="center"  width="120px" height="113px">
					<%	} else { %>
						<IMG SRC="seatImg/offseat16.jpg" id ="seat16" align="center"  width="120px" height="113px">
					<% 	} %>
				</td>
				<td width="120px" height="113px">
					<%	if (list.get(16).getCondition() == 1) { %>
						<IMG SRC="seatImg/onseat17.jpg" id ="seat17" align="center"  width="120px" height="113px">
					<%	} else { %>
						<IMG SRC="seatImg/offseat17.jpg" id ="seat17" align="center"  width="120px" height="113px">
					<% 	} %>
				</td>
				<td width="120px" height="113px">
					<%	if (list.get(17).getCondition() == 1) { %>
						<IMG SRC="seatImg/onseat18.jpg" id ="seat18" align="center"  width="120px" height="113px">
					<%	} else { %>
						<IMG SRC="seatImg/offseat18.jpg" id ="seat18" align="center"  width="120px" height="113px">
					<% 	} %>
				</td>
				<td width="120px" height="113px">
					<%	if (list.get(18).getCondition() == 1) { %>
						<IMG SRC="seatImg/onseat19.jpg"  id ="seat19" align="center"  width="120px" height="113px">
					<%	} else { %>
						<IMG SRC="seatImg/offseat19.jpg" id ="seat19" align="center"  width="120px" height="113px">
					<% 	} %>
				</td>
				<td width="120px" height="113px">
				<%	if (list.get(19).getCondition() == 1) { %>
						<IMG SRC="seatImg/onseat20.jpg" id ="seat20" align="center"  width="120px" height="113px">
				<%	} else { %>
						<IMG SRC="seatImg/offseat20.jpg" id ="seat20" align="center"  width="120px" height="113px">
				<% 	} %>
				</td>
				</tr>
				
				<tr>
				<td width="120px" height="113px">
					<%	if (list.get(20).getCondition() == 1) { %>
						<IMG SRC="seatImg/onseat21.jpg" id ="seat21" align="center"  width="120px" height="113px">
					<%	} else { %>
						<IMG SRC="seatImg/offseat21.jpg" id ="seat21" align="center"  width="120px" height="113px">
					<% 	} %>
				</td>
				<td width="120px" height="113px">
					<%	if (list.get(21).getCondition() == 1) { %>
						<IMG SRC="seatImg/onseat22.jpg" id ="seat22" align="center"  width="120px" height="113px">
					<%	} else { %>
						<IMG SRC="seatImg/offseat22.jpg" id ="seat22" align="center"  width="120px" height="113px">
					<% 	} %>
				</td>
				<td width="120px" height="113px">
					<%	if (list.get(22).getCondition() == 1) { %>
						<IMG SRC="seatImg/onseat23.jpg" id ="seat23" align="center"  width="120px" height="113px">
					<%	} else { %>
						<IMG SRC="seatImg/offseat23.jpg" id ="seat23" align="center"  width="120px" height="113px">
					<% 	} %>
				</td>
				<td width="120px" height="113px">
					<%	if (list.get(23).getCondition() == 1) { %>
						<IMG SRC="seatImg/onseat24.jpg" id ="seat24" align="center"  width="120px" height="113px">
					<%	} else { %>
						<IMG SRC="seatImg/offseat24.jpg" id ="seat24" align="center"  width="120px" height="113px">
					<% 	} %>
				</td>
				<td width="120px" height="113px">
					<%	if (list.get(24).getCondition() == 1) { %>
						<IMG SRC="seatImg/onseat25.jpg" id ="seat25" align="center"  width="120px" height="113px">
					<%	} else { %>
						<IMG SRC="seatImg/offseat25.jpg" id ="seat25" align="center"  width="120px" height="113px">
					<% 	} %>
				</td>
				</tr>
				
				<tr>
				<td width="120px" height="113px">
					<%	if (list.get(25).getCondition() == 1) { %>
						<IMG SRC="seatImg/onseat26.jpg" id ="seat26" align="center"  width="120px" height="113px">
					<%	} else { %>
						<IMG SRC="seatImg/offseat26.jpg" id ="seat26" align="center"  width="120px" height="113px">
					<% 	} %>
				</td>
				<td width="120px" height="113px">
					<%	if (list.get(26).getCondition() == 1) { %>
						<IMG SRC="seatImg/onseat27.jpg" id ="seat28" align="center"  width="120px" height="113px">
					<%	} else { %>
						<IMG SRC="seatImg/offseat27.jpg" id ="seat28" align="center"  width="120px" height="113px">
					<% 	} %>
				</td>
				<td width="120px" height="113px">
					<%	if (list.get(27).getCondition() == 1) { %>
						<IMG SRC="seatImg/onseat28.jpg" id ="seat29" align="center"  width="120px" height="113px">
					<%	} else { %>
						<IMG SRC="seatImg/offseat28.jpg" id ="seat29" align="center"  width="120px" height="113px">
					<% 	} %>
				</td>
				<td width="120px" height="113px">
					<%	if (list.get(28).getCondition() == 1) { %>
						<IMG SRC="seatImg/onseat29.jpg" id ="seat29" align="center"  width="120px" height="113px">
					<%	} else { %>
						<IMG SRC="seatImg/offseat29.jpg" id ="seat29" align="center"  width="120px" height="113px">
					<% 	} %>
				</td>
				<td width="120px" height="113px">
					<%	if (list.get(29).getCondition() == 1) { %>
						<IMG SRC="seatImg/onseat30.jpg" id ="seat30" align="center"  width="120px" height="113px">
					<%	} else { %>
						<IMG SRC="seatImg/offseat30.jpg" id ="seat30" align="center"  width="120px" height="113px">
					<% 	} %>
				</td>
				</tr>
		<tr>
			<td colspan="5"><input type="reset" value="새로고침" >
			</td>
		</tr>
		
	</table>
</form>


</body>
</html>