<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title>채팅페이지</title>
</head>
<body>  
<input id="inputMessage" type="text"
		onkeydown="if(event.keyCode==13){send();}" />
<input type="submit" value="send" onclick="send();"/>
<div id="messageWindow2" style="padding:10px 0; height: 20em; overflow: auto; background-color: #a0c0d7;"></div>
</body>

<%
	
	String id = "";
	if (session.getAttribute("id") != null) {
		id = (String) session.getAttribute("id");
	}
	
	String nick = (String)session.getAttribute("memberId");
	if (session.getAttribute("nick") != null) {
		nick = (String) session.getAttribute("nick");
	} else {
		nick = (String)session.getAttribute("memberId");
	}
%>
	<script type="text/javascript">
		var webSocket = new WebSocket('ws://localhost:8070/pcm/broadcasting');
		var inputMessage = document.getElementById('inputMessage');
		var re_send = "";
		
		webSocket.onerror = function(event) {
			onError(event)
		};
		webSocket.onopen = function(event) {
			onOpen(event)
		};
		webSocket.onmessage = function(event) {
			onMessage(event)
		};
		
		function onMessage(event) {
			
			var message = event.data.split("|");
				if(message[0] != re_send) {
					var who = document.createElement('div');
					
					who.style["padding"]="3px";
					who.style["margin-left"]="3px";
					
					who.innerHTML = message[0];
					document.getElementById('messageWindow2').appendChild(who);
					
					re_send = message[0];
				}
				
				var div=document.createElement('div');
				
				div.style["width"]="auto";
				div.style["word-wrap"]="break-word";
				div.style["display"]="inline-block";
				div.style["background-color"]="#fcfcfc";
				div.style["border-radius"]="3px";
				div.style["padding"]="3px";
				div.style["margin-left"]="3px";
				
				div.innerHTML = message[1];
				document.getElementById('messageWindow2').appendChild(div);
				
			var clear=document.createElement('div');
			clear.style["clear"]="both";
			document.getElementById('messageWindow2').appendChild(clear);
			
			messageWindow2.scrollTop = messageWindow2.scrollHeight;
		}
		
		function onClose(event) {
			var div=document.createElement('div');
			
			webSocket.send("<%=nick%> is DisConnected\n");
		}
		
		function onOpen(event) {
			var div=document.createElement('div');
			
			div.style["text-align"]="center";
			
			div.innerHTML = "바르고 고운말을 사용합시다!";
			document.getElementById('messageWindow2').appendChild(div);
			
			var clear=document.createElement('div');
			clear.style["clear"]="both";
			document.getElementById('messageWindow2').appendChild(clear);
			
			webSocket.send("<%=nick%>|안녕하세요^^");
		}
		
		function onError(event) {
			alert("chat_server connecting error " + event.data);
		}
		
		function send() {
			
			if(inputMessage.value!=""){
				webSocket.send("<%=nick%>|"+ inputMessage.value);
				
				var div=document.createElement('div');
				
				div.style["width"]="auto";
				div.style["word-wrap"]="break-word";
				div.style["float"]="right";
				div.style["display"]="inline-block";
				div.style["background-color"]="#ffea00";
				div.style["padding"]="3px";
				div.style["border-radius"]="3px";
				div.style["margin-right"]="3px";
				
				div.innerHTML = inputMessage.value;
				document.getElementById('messageWindow2').appendChild(div);
				
				var clear = document.createElement('div');
				clear.style["clear"] = "both";
				document.getElementById('messageWindow2').appendChild(clear);
				
				inputMessage.value = '';
				
				messageWindow2.scrollTop = messageWindow2.scrollHeight;
				
				re_send = "<%=nick%>";
			}
		}
	</script>
</html>