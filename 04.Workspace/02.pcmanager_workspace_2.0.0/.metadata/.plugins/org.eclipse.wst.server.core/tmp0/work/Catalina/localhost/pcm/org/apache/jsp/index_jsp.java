/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.16
 * Generated at: 2017-07-21 01:03:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/C:/01.web_project/wokrspace/02.pcmanager_workspace_2.0.0/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/pcmanager.3.0.0/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1500469334000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!-- jstl cofing -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=EUC-KR\">\r\n");
      out.write("<title>PC</title>\r\n");
      out.write("\r\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"css/common.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"Resources/css/bootstrap.css\">\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("\tbody {\r\n");
      out.write("\t\tbackground-image: url('img/pcbackground2.jpg'); background-size: cover;\r\n");
      out.write("\t\tbackground-repeat : no-repeat;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\t/* Set a style for all buttons */\r\n");
      out.write("\tbutton {\r\n");
      out.write("\t    background-color: #fcb259;\r\n");
      out.write("\t    color: white;\r\n");
      out.write("\t    padding: 14px 20px;\r\n");
      out.write("\t    margin: 8px 0;\r\n");
      out.write("\t    border: none;\r\n");
      out.write("\t    cursor: pointer;\r\n");
      out.write("\t    width: 100%;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tbutton:hover {\r\n");
      out.write("\t    opacity: 0.8;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t/* Extra styles for the cancel button */\r\n");
      out.write("\t.cancelbtn {\r\n");
      out.write("\t    width: auto;\r\n");
      out.write("\t    padding: 10px 18px;\r\n");
      out.write("\t    font-size: 20px;\r\n");
      out.write("\t    background-color: #e15b50;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.cancelbtn2 {\r\n");
      out.write("    padding: 14px 14px;\r\n");
      out.write("    background-color: #fcb259;\r\n");
      out.write("    font-size: 20px;\r\n");
      out.write("    float:left;\r\n");
      out.write("    width:50%;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.signbtn {\r\n");
      out.write("\t    padding: 14px 14px;\r\n");
      out.write("\t    background-color: #fcb259;\r\n");
      out.write("\t    font-size: 20px;\r\n");
      out.write("\t    float:left;\r\n");
      out.write("\t    width:100%;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t/* Center the image and position the close button */\r\n");
      out.write("\t.imgcontainer {\r\n");
      out.write("\t    text-align: center;\r\n");
      out.write("\t    margin: 24px 0 12px 0;\r\n");
      out.write("\t    position: relative;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.container {\r\n");
      out.write("    padding: 16px;\r\n");
      out.write("}\r\n");
      out.write("\t\r\n");
      out.write("\timg.avatar {\r\n");
      out.write("\t    width: 40%;\r\n");
      out.write("\t    border-radius: 40%;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.container {\r\n");
      out.write("\t    padding: 16px;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tspan.psw {\r\n");
      out.write("\t    float: right;\r\n");
      out.write("\t    padding-top: 16px;\r\n");
      out.write("\t    font-size: 20px;\r\n");
      out.write("\t    font-color: #f2f2f2;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t/* The Modal (background) */\r\n");
      out.write("\t.modal {\r\n");
      out.write("\t    display: none; /* Hidden by default */\r\n");
      out.write("\t    position: fixed; /* Stay in place */\r\n");
      out.write("\t    z-index: 1; /* Sit on top */\r\n");
      out.write("\t    left: 0;\r\n");
      out.write("\t    top: 0;\r\n");
      out.write("\t    width: 100%; /* Full width */\r\n");
      out.write("\t    height: 100%; /* Full height */\r\n");
      out.write("\t    overflow: auto; /* Enable scroll if needed */\r\n");
      out.write("\t    background-color: #17181d; /* Fallback color */\r\n");
      out.write("\t    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */\r\n");
      out.write("\t    padding-top: 60px;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t/* Modal Content/Box */\r\n");
      out.write("\t.modal-content {\r\n");
      out.write("\t    background-color: #17181d;\r\n");
      out.write("\t    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */\r\n");
      out.write("\t    border: 1px solid #888;\r\n");
      out.write("\t    width: 80%; /* Could be more or less, depending on screen size */\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.radio {\r\n");
      out.write("\tfont-color: #f2f2f2;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t/* The Close Button (x) */\r\n");
      out.write("\t.close {\r\n");
      out.write("\t    position: absolute;\r\n");
      out.write("\t    right: 35px;\r\n");
      out.write("\t    top: 15px;\r\n");
      out.write("\t    color: #000;\r\n");
      out.write("\t    font-size: 40px;\r\n");
      out.write("\t    font-weight: bold;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.close:hover,\r\n");
      out.write("\t.close:focus {\r\n");
      out.write("\t    color: red;\r\n");
      out.write("\t    cursor: pointer;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t/* Clear floats */\r\n");
      out.write("\t.clearfix::after {\r\n");
      out.write("\t    content: \"\";\r\n");
      out.write("\t    clear: both;\r\n");
      out.write("\t    display: table;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t/* Add Zoom Animation */\r\n");
      out.write("\t.animate {\r\n");
      out.write("\t    -webkit-animation: animatezoom 0.6s;\r\n");
      out.write("\t    animation: animatezoom 0.6s\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t@-webkit-keyframes animatezoom {\r\n");
      out.write("\t    from {-webkit-transform: scale(0)} \r\n");
      out.write("\t    to {-webkit-transform: scale(1)}\r\n");
      out.write("\t}\r\n");
      out.write("\t    \r\n");
      out.write("\t@keyframes animatezoom {\r\n");
      out.write("\t    from {transform: scale(0)} \r\n");
      out.write("\t    to {transform: scale(1)}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t/* Change styles for span and cancel button on extra small screens */\r\n");
      out.write("\t@media screen and (max-width: 300px) {\r\n");
      out.write("\t    span.psw {\r\n");
      out.write("\t       display: block;\r\n");
      out.write("\t       float: none;\r\n");
      out.write("\t    }\r\n");
      out.write("\t    .cancelbtn, .signupbtn{\r\n");
      out.write("\t       width: 50%;\r\n");
      out.write("\t    }\r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<!-- internal js -->\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction winfind() {\r\n");
      out.write("\t\tvar winName=\"아이디/비밀번호 찾기\";\r\n");
      out.write("\r\n");
      out.write("\t\tflag = \"left=200, \"; //창뜨는위치\r\n");
      out.write("\t\tflag += \"top=200, \"; //창뜨는위치\r\n");
      out.write("\t\tflag += \"width=800, \"; //창크기\r\n");
      out.write("\t\tflag += \"height=515\"; //창크기\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\twindow.open(\"/pcm/member/memberIdAndPw.jsp\", winName, flag)\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"document.getElementById('id01').style.display='block'\">\r\n");
      out.write("\r\n");
      out.write("<table width=\"2000px\">\r\n");
      out.write("<tr> \r\n");
      out.write("<td width=\"1160px\" height=\"760px\">\r\n");
      out.write("</td>\r\n");
      out.write("<td>\r\n");
      out.write("\t<button type=\"button\" class=\"btn btn-danger btn-lg\" onclick=\"document.getElementById('id01').style.display='block'\" style=\"width:auto;\">로그인</button><br><br>\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("c\r\n");
      out.write("\r\n");
      out.write("<div id=\"id01\" class=\"modal\">\r\n");
      out.write("  \r\n");
      out.write("  <form class=\"modal-content animate\" action=\"/pcm/controller?action=login\" method=\"post\">\r\n");
      out.write("    <div class=\"imgcontainer\">\r\n");
      out.write("      <span onclick=\"document.getElementById('id01').style.display='none'\" class=\"close\" title=\"Close Modal\">&times;</span>\r\n");
      out.write("      <img src=\"./img/loginlogo.jpg\" alt=\"Avatar\" class=\"avatar\">\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("      <font color=\"#f2f2f2\">\r\n");
      out.write("      <label><b>UserName</b></label>     \r\n");
      out.write("      <input type=\"text\" placeholder=\"Enter Username\" name=\"memberId\" required>\r\n");
      out.write("      <font color=\"#f2f2f2\">\r\n");
      out.write("      <label><b>Password</b></label>\r\n");
      out.write("      <input type=\"password\" placeholder=\"Enter Password\" name=\"memberPw\" required>\r\n");
      out.write("        \r\n");
      out.write("      <button class=\"btn btn-warning btn-lg\" type=\"submit\"><b>로그인</b></button>\r\n");
      out.write("      <input type=\"checkbox\" checked=\"checked\"> Remember me\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"container\" style=\"background-color:#17181d\">\r\n");
      out.write("      <button type=\"button\" class=\"btn-danger btn-lg caclebtn\" onclick=\"document.getElementById('id01').style.display='none'\" style=\"width:auto;\">Cancel</button>\r\n");
      out.write("      <button type=\"button\" class=\"btn-primary btn-lg\" onclick=\"document.getElementById('id02').style.display='block', document.getElementById('id01').style.display='none'\" style=\"width:auto;\">회원가입</button>\r\n");
      out.write("      <div align=\"right\"><button type=\"button\" class=\"btn btn-success btn-lg\" onclick=\"winfind(), document.getElementById('id01').style.display='none'\" style=\"width:auto;\">아이디/비밀번호 찾기</button>\r\n");
      out.write("      </div>      \r\n");
      out.write("    </div>\r\n");
      out.write("  </form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"id02\" class=\"modal\">\r\n");
      out.write("  <span onclick=\"document.getElementById('id02').style.display='none'\" class=\"close\" title=\"Close Modal\">×</span>\r\n");
      out.write("  <form class=\"modal-content animate\" action=\"/pcm/controller?action=joinSave\" method=\"post\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("    <font color=\"#f2f2f2\">\r\n");
      out.write("      <label><b>아이디</b></label>\r\n");
      out.write("      <input type=\"text\" placeholder=\"아이디 4~20자리 이내\" name=\"memberId\" required title=\"아이디 입력\">\r\n");
      out.write("\t<font color=\"#f2f2f2\">\r\n");
      out.write("      <label><b>비밀번호</b></label>\r\n");
      out.write("      <input type=\"password\" placeholder=\"비밀번호 6~20자리 이내\" name=\"memberPw\" required=\"비밀번호 입력\">\r\n");
      out.write("\t<font color=\"#f2f2f2\">\r\n");
      out.write("      <label><b>비밀번호 확인</b></label>\r\n");
      out.write("      <input type=\"password\" placeholder=\"비밀번호 확인\" name=\"memberPw\" required><br><br>\r\n");
      out.write("    <font color=\"#f2f2f2\">\r\n");
      out.write("      <label><b>이름</b></label>\r\n");
      out.write("      <input type=\"text\" placeholder=\"이름\" name=\"memberName\" required title=\"이름 입력\">\r\n");
      out.write("    <font color=\"#f2f2f2\">\r\n");
      out.write("      <label><b>성별</b></label>\r\n");
      out.write("      <input class=\"radio\" type=\"radio\" name=\"gender\" value=\"남\" checked>남 &nbsp;\r\n");
      out.write("\t  <input class=\"radio\" type=\"radio\" name=\"gender\" value=\"여\" checked>여<br><br>\r\n");
      out.write("      <font color=\"#f2f2f2\">\r\n");
      out.write("     <label><b>생년월일</b></label>\r\n");
      out.write("      <input type=\"text\" name=\"birthDate\" maxlength=\"12\" placeholder=\"년(4자)/월(2자)/일(2자)\"><br>\r\n");
      out.write("\t<font color=\"#f2f2f2\">\r\n");
      out.write("\t <label><b>연락처</b></label>\r\n");
      out.write("      <input type=\"text\" name =\"mobile\" required\r\n");
      out.write("\t\t\tplaceholder=\"연락처 필수항목\" title=\"휴대폰 입력\">\t\r\n");
      out.write("\t<font color=\"#f2f2f2\">\r\n");
      out.write("\t <label><b>이메일</b></label>\r\n");
      out.write("\t  <input type=\"text\" name =\"email\" required \r\n");
      out.write("\t\t\tplaceholder=\"이메일 필수항목\" title=\"이메일 입력\"><br>\r\n");
      out.write("\t<font color=\"#f2f2f2\">\r\n");
      out.write("\t<label><b>주소</b></label>\r\n");
      out.write("\t<input type=\"text\" size=\"50\" name=\"address\"/><br><br>\r\n");
      out.write("\t\r\n");
      out.write("      <div class=\"clearfix\">\r\n");
      out.write("        <button type=\"button\" onclick=\"document.getElementById('id02').style.display='none'\" class=\"btn-danger btn-lg caclebtn\">Cancel</button>\r\n");
      out.write("        <button type=\"submit\" class=\"btn-success btn-lg signupbtn\" >가입</button>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("// Get the modal\r\n");
      out.write("var modal = document.getElementById('id01');\r\n");
      out.write("\r\n");
      out.write("// When the user clicks anywhere outside of the modal, close it\r\n");
      out.write("window.onclick = function(event) {\r\n");
      out.write("    if (event.target == modal) {\r\n");
      out.write("        modal.style.display = \"none\";\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("var modal2 = document.getElementById('id02');\r\n");
      out.write("\r\n");
      out.write("//When the user clicks anywhere outside of the modal2, close it\r\n");
      out.write("window.onclick = function(event) {\r\n");
      out.write(" if (event.target == modal2) {\r\n");
      out.write("     modal2.style.display = \"none\";\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- footer area -->\r\n");
      out.write("<script src=\"http://ajax.googleapis.com/ajax/libs/jqery/1.12.4/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/bootstrap.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}