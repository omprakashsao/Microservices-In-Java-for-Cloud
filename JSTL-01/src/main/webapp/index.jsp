<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UI PAGE</title>
</head>
<body>
	<h1>
	  Your Name is :  <c:out value="${param.user}"></c:out>
	</h1>
	
<h2>
   <c:set var="x" value="34"></c:set>
   
  <c:set var="y" value="33"/>
  <p>Value of x: <c:out value="${x}"/></p>
  <p>Value of y: <c:out value="${y}" /></p>  
  <p>Sum of x and y is: <c:out value="${x+y}" default="3888"/></p>
</h2>
	
	<c:if test="${not empty param.user }" >
	 Mr./Ms <c:out value="${ param.user}" />
	</c:if>
	
	<c:choose>
	   <c:when test="${not empty param.user }">
	       <c:out value="${param.user}" /> are authorize successfully..
	   </c:when>
	   <c:otherwise>
	       <c:out value="you are unauthorize person.." />
	   </c:otherwise>
	</c:choose>
	
</body>
</html>
