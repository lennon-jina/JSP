<%@page import="jdbc.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jdbc.UserService" %>
<%@ page import="jdbc.UserVO" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		System.out.println(request.getParameter("userId"));
		System.out.println(request.getParameter("userPw"));
		UserService service = UserService.getInstance();
		UserVO user = service.loginUser(request.getParameter("userId")
									  , request.getParameter("userPw"));
		System.out.println(user);
		PrintWriter script = response.getWriter();
		script.println("<script>");
		if(user != null) {
			session.setAttribute("userId", user.getUserId());
			session.setMaxInactiveInterval(5 * 60);   // 5분 (설정 안하면 디폴트 30분)
			script.println("' " + user.getUserNm() + " 님 환영! '; ");
			script.println("location.href='main.jsp'");
		} else {
			script.println("alert('아이디/비번을 입력하세요!'); ");
			script.println("history.back();");
		}
		script.println("</script>");
	%>
</body>
</html>