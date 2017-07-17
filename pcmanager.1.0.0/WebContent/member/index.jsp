<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<!-- external css : css/common.css -->
<link type="text/css" rel="stylesheet" href="css/common.css">

<!-- internal js -->
<script type="text/javascript">
	mainSlideImages = new Array();
	mainSlideImages[0] = "img/main1.jpg";
	mainSlideImages[1] = "img/main2.jpg";
	mainSlideImages[2] = "img/main3.jpg";
	mainSlideImages[3] = "img/main4.jpg";
	mainSlideImages[4] = "img/main5.jpg";
	mainSlideImages[5] = "img/main6.jpg";
	mainSlideImages[6] = "img/main7.jpg";
	imgIndex = 0;
	
	function previousImg() {
		var  slideImgElement = document.getElementById("slideMainImg");
		
		if (imgIndex > 0) {
			--imgIndex;
		} else {
			imgIndex = 6;
		}
		slideImgElement.src = mainSlideImages[imgIndex];
	}
	
	function nextImg() {
		var  slideImgElement = document.getElementById("slideMainImg");
		if (imgIndex < (mainSlideImages.length-1)) {
			++imgIndex;
		} else {
			imgIndex = 0;
		}
		slideImgElement.src = mainSlideImages[imgIndex];
	}
</script>

</head>
<body>

<!-- header area -->
<!-- logo link -->
<a href="index.jsp">
<img src="logo.gif" onblur="시작페이지 이동">
</a>
<hr>

<!-- 로그인 전 메뉴 -->
<div class="menu_area" style="text-align:right;">
<a class="normal" href="login.jsp">로그인</a>
<a class="normal" href="join.jsp">회원가입</a>
<a class="normal" href="memberIdAndPw.jsp">아이디/비밀번호 찾기</a>
</div>
<hr>


<!-- content area -->
<div class="slide_area" style="text-align:center;">
<span>
<img src="img/btn_previous.gif" name="btn_previous" onclick="previousImg()">
</span>
<span><img src="img/main1.jpg" name="slideMainImg" id="slideMainImg"></span>
<span>
<img src="img/btn_next.gif" name="btn_next" onclick="nextImg()">
</span>
</div>
<hr>

<!-- footer area -->
<div class="footer_area" style="text-align:center;">
COPYRIGHT 2017 WORK. ALL RIGHTS RESERVED
</div>

</body>
</html>











