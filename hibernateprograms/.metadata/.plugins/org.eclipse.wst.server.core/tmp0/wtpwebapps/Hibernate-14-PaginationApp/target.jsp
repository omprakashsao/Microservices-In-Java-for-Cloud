<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TARGET PAGE</title>
</head>
<body>
	<c:choose>
		<c:when test="${policyList ne null && !empty policyList }">
			<table>
				<tr>
					<th>Serial No.</th>
					<th>PolicyID</th>
					<th>PolicyName</th>
					<th>PolicyType</th>
					<th>Company</th>
					<th>Tenure</th>
					
				</tr>
				<c:forEach var="dto" items="${policyList }">
					<tr>
						<td>${dto.serialNo }</td>
						<td>${dto.policyId }</td>
						<td>${dto.policyName }</td>
						<td>${dto.policyType }</td>
						<td>${dto.company }</td>
						<td>${dto.tenure }</td>
						
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h1 style='color:red, text-align:center;'>
				NO RECORD FOUND
				
			</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>