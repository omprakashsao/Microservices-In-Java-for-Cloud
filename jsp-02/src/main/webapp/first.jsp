<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>
 jsp header
</h1>

<h1>
<% pageContext.forward("second.jsp"); %>

<!-- when we write include rather than forward all jsp pages out put include all jsp --convert-> _jsp.java   -->
</h1>

<h1>
jsp footer
</h1>
</body>
</html>