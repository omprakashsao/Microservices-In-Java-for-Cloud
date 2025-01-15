<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    isErrorPage="true"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Jsp</title>
</head>
<body>
<b><i>Some error occur due to internal issues</i></b>
<br>
<b>exception is:: <%= exception.toString() %></b>
</body>
</html>