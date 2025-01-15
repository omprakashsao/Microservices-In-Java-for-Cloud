<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  
  <jsp:useBean id="student" class="in.ops.om.beans.Student" scope="page" >
  <jsp:setProperty property="*" name="student"/>
  
  </jsp:useBean>
  
  <table>
  <thead>
  <th>Name</th>
  <th>Age</th>
  <th>Address</th>
  </thead>
  
  <tbody>
  <tr>
  <td><jsp:getProperty property="name" name="student"/></td>
  <td><jsp:getProperty property="age" name="student"/></td>
  <td><jsp:getProperty property="address" name="student"/></td>
  </tr>
  </tbody>
  
  </table>
  
 <h1>
 <jsp:include page="second.jsp" />
 </h1>
  
</body>
</html>