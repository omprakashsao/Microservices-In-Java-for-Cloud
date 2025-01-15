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

  <h1>Username is : <c:out value="${param.user}" /></h1>
  
  <c:catch var="e">
    <% int age = Integer.parseInt(request.getParameter("age"));
       %>
    
    
    Your age is : <c:out value="${param.age}" />
  </c:catch>
  
  <c:if test="${ e ne null }">
   Exception is raised : <c:out value="${e}" />
  </c:if>
  
  <h1>Working with foreach tag</h1>
  
  <table border="1" align="center" width="200" >
  <c:forEach begin="1" end="10" var="i">
      <tr style="text-align: center;">
         <td>2*${i}=</td>
         <td>${2*i}</td>
      </tr>    
  </c:forEach>
  
 
  </table>
  
   <% 
     String[] names = {"Om" , "Shivam" , "Sunny" };
     pageContext.setAttribute("name", names);
  %>
  
  <c:forEach var="i" items="${name}" >
     <c:out value="${i}"></c:out>
  </c:forEach>
  
  <%
    ArrayList<Student> stdList = new ArrayList<>();
  
    stdList.add(new Student(1,"om",23));
    stdList.add(new Student(2,"shivam",24));
    stdList.add(new Student(3,"sunny",25));
    
    pageContext.setAttribute("stdListItems", stdList);
  
  %>
  
  <h1>${stdListItems[0].sid }</h1>
  
  <table>
  <c:choose>
  <c:when test="${ !empty stdListItems and stdListItems ne null }">
    <c:forEach items="${stdListItems }" var="student">
       <tr>
          <th>ID</th>
          <th>Name</th>
          <th>AGE</th>
       </tr>
       
       <tr>
        <td>${student.sid}</td>
        <td>${student.sname }</td>
        <td>${student.sage}</td>
       </tr>
    </c:forEach>
  </c:when>
  <c:otherwise>
          <c:out value="Student record not found..."></c:out>
  </c:otherwise>
  </c:choose>
  </table>
  <%
     String sentence = "hello, hey, look here!!";
     pageContext.setAttribute("sen", sentence);
  %>
  <c:forTokens var="s" items="${sen}" delims=",">
    <h1><c:out value="${s}" /></h1>
  </c:forTokens>
  
  
  
  
  
  
  
  
  
  
  
</body>
</html>