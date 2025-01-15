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
     Second JSP Page....
     </h1>
     
     <br/>
     
     <h2>BookName is :: <%= request.getParameter("bookName") %></h2>
     <h2>Amount is   :: <%= request.getParameter("amount") %></h2>
</body>
</html>