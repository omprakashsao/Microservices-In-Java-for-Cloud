<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>User Name is:: ${initParam.username}</h1><br/>
<h1>Password  is:: ${initParam.password}</h1><br/>
<h1>EmailId   is:: ${initParam.emailid}</h1><br/>

<h1>Working with pageContext Object...</h1>
<h1>PageContext Object:: ${pageContext}</h1>
<h1>Session Id:: ${pageContext.session.id}</h1>
<h1>Request Method:: ${pageContext.request.method}</h1>
<h1>Header name is :: ${header}</h1>

<b>Working with Array...</b>

<% String[] names= {"Om", "neeraj" , "deepanshu", "Lukesh"};
   request.setAttribute("name", names);
   request.setAttribute("index", 3);
%>

<h1> ${name[0]}</h1>
<h1> ${name["1"]}</h1>
<h1> ${name['2']}</h1>
<h1>${name[3]}</h1>

<%
  ArrayList<String> al = new ArrayList<>();
  al.add("hostel");
  al.add("college");
  al.add("university");
  
  request.setAttribute("place", al);
%>

<h1>Working with ArrayList....</h1>
 <h1> ${place[0] }</h1>
 <h1>${place[1]}</h1>
 <h1>${place[2]}</h1>
 
 <h1>EL with null</h1>
 <h1>${10 + null}</h1>
 <h1>${!null }</h1>
<h1>${empty al }</h1>
</body>
</html>