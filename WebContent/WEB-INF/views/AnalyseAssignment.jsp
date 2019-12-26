
<%@page import="com.sims.model.AllocateAssignment"%>
<%@page import="java.util.ArrayList"%>
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

<h1>Analyse Assignment</h1>  <a href="assignmentView.jsp" ><button>Back</button></a>
<center>
	<table border="1" cellpadding="12">
		 <caption><h2>Analyse Assignment</h2></caption>
		 
		 <tr>
		 <td>Teacher Name</td>
		 <td>Class</td>
		 <td>Period</td>
		 <td>Description</td>
		 </tr>
		 
		 <%
		 ArrayList<AllocateAssignment> alocateAssignment = (ArrayList<AllocateAssignment>)request.getAttribute("allocateAssignment");
	
		 for(AllocateAssignment assignment : alocateAssignment ){
		 %>
		 <tr>
		 <th><%=assignment.getTeacherName() %></th>
		 <th><%=assignment.getClassName() %></th>
		 <th><%=assignment.getPeriod() %></th>
		 <th><%=assignment.getAssignmentDes() %></th>
		 </tr>
		 <% } %>
	</table>
	</center>
	
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>