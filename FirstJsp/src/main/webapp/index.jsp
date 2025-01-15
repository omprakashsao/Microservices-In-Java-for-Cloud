<%@ page language="java" 
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="java.util.*"
         session="false" 
         isELIgnored="false"
         errorPage="error.jsp"
         isThreadSafe="false"
         buffer="8kb"
         autoFlush="false"
         %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
Server time is :: <%= new java.util.Date() %>
</h1>
<h1>
<%= new Scanner(System.in) %>
</h1>

<h1>User name is :: ${param.user}</h1>

<% int x = Integer.parseInt("12"); %>
<h1>value is:: <%= x %></h1>

<%
   for(int y =0; y<100000 ; y++){
	  out.write(" hello");
   }
%>

</body>
</html>