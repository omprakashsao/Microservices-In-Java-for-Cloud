<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   
   <form action="./first.jsp">
     <table>
		<tbody>
		  <tr>
		  <td>Name:</td>
		  <td><input type="text" name="name"/></td>
		  </tr>
		  
		  <tr>
		  <td>Age:</td>
		  <td><input type="text" name="age"/></td>
		  </tr>
		  
		  <tr>
		  <td>Address:</td>
		  <td><input type="text" name="address"/></td>
		  </tr>
		  
		  <tr ><td colspan = "2"><input type="submit" value="register"/></td></tr>
		</tbody>     
     </table>
   </form>
</body>
</html>