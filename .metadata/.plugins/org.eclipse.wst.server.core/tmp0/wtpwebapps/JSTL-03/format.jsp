<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<fmt:formatNumber type="currency" var="money" value="34342432332"/>
<h1>Actual earning: ${money}</h1>

<jsp:useBean id="dt" class="java.util.Date" />
<fmt:formatDate value="${dt}" var="date" type="both"/>

<h1>date is: ${date}</h1>

<fmt:setLocale value="fi-FR" />

<fmt:setBundle basename="in/ops/om/properties/App" />

<fmt:message var="msg1" key="welcome.msg"/>
<fmt:message var="msg2" key="goodbye.msg"></fmt:message>

<h1>msg1 : ${msg1}</h1>
<h1>msg2 : ${msg2}</h1>
 
</body>
</html>