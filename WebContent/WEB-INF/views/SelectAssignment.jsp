<%@page import="com.sims.model.Assignment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="Style.css" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	<%
		Assignment assignment = (Assignment) request.getAttribute("assignment");
	%>
	<form method="post" action="UpdateServlet">
		<select name="class">
			<option><%=assignment.getClass_()%></option>
			<option>10A</option>
			<option>10B</option>
			<option>9A</option>
			<option>9C</option>
			<option>9B</option>
		</select> <br> <br>

		<textarea rows="4" cols="50" name="description"><%=assignment.getDescpt()%></textarea>

		<br> <br> <input type="hidden" name="assignmentID"
			value="<%=assignment.getAssignmentId()%>" />

		<button type="submit">Update Assignment</button>
		</br>
		</br>
	</form>

	<form method="post" action="DeleteServlet">
		<input type="hidden" name="assignmentID"
			value="<%=assignment.getAssignmentId()%>" />
		<button type="submit">Delete Assignment</button>
		</br>
		</br>
	</form>
	
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>