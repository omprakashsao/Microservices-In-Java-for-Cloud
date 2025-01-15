<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*, in.ops.om.beans.*"
    
    %>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UI PAGE</title>
</head>
<body>

  
  
  
  <%
    ArrayList<Student> stdList = new ArrayList<>();
  
    stdList.add(new Student(1,"om",23,"bhilai"));
    stdList.add(new Student(2,"shivam",24,"Korba"));
    stdList.add(new Student(3,"sunny",25, "Raipur"));
    
    pageContext.setAttribute("stdListItems", stdList);
  
  %>
  
  <h1>${stdListItems[0].sid }</h1>
  
  <table>
  <c:choose>
  <c:when test="${ !empty stdListItems and stdListItems ne null }">
       <tr>
          <th>Name</th>
          <th>AGE</th>
          <th>ADDRESS</th>
          <th>SUBJECT</th>
          <th>ACTIONS</th>
       </tr>
    <c:forEach items="${stdListItems }" var="student">
       <c:url var="updateLink" value="/student/update">
       		<c:param name="sid" value="${student.sid}" />
       </c:url>
       
       <c:url var="deleteLink" value="/student/delete">
            <c:param name="sid" value="${student.sid}" />
       </c:url>
       <tr>
        <td>${student.sname }</td>
        <td>${student.sage}</td>
        <td>${param.UI} and ${param.framework }</td>
        <td>${student.saddress}</td>
        <td>
          <a href='${updateLink}'>UPDATE</a>
          |
          <a href='${deleteLink} }'>DELETE</a>
        </td>
       </tr>
    </c:forEach>
  </c:when>
  <c:otherwise>
          <c:out value="Student record not found..."></c:out>
  </c:otherwise>
  </c:choose>
  </table>
 
  
  
  
  
  
  
  
  
  
  
  
</body>
</html>