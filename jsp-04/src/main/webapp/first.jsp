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
 starting of first jsp
</h1>

<%
  float balanceAmt = 3.444f*4.5f+7.55f;
  System.out.println(balanceAmt);
%>

 <jsp:forward page="second.jsp">
  <jsp:param value="JSP" name="bookName"/>
  <jsp:param value="<%= balanceAmt %>" name="amount"/>
 </jsp:forward>
</body>
</html>