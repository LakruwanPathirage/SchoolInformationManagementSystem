<%@page import="com.sims.model.Teacher"%>
<%@page import="com.sims.service.TeacherServiceIMPL"%>
<%@page import="com.sims.service.ITeacherService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.ArrayList"%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="Style.css" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css" href="Style.css" />
<meta charset="ISO-8859-1">
<title>Teacher Details</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>


	<div align="left">
		<table border="1" cellpadding="12">
			<caption>
				<h2>List of Teachers</h2>
			</caption>

			<tr>
				<th>Registered ID</th>
				<th>Name</th>
				<th>Address</th>
				<th>Designation</th>
				<th>Subject</th>
				<th>Section</th>
				<th>Qualifications</th>
				<th>Gender</th>
				<th>Select</th>
			</tr>

			<%
				ITeacherService iTeacherService = new TeacherServiceIMPL();
				ArrayList<Teacher> arrayList = iTeacherService.getTeachers();

				for (Teacher teacher : arrayList) {
			%>



			<tr>
				<td><%=teacher.getTeacherID()%></td>
				<td><%=teacher.getName()%></td>
				<td><%=teacher.getAddress()%></td>
				<td><%=teacher.getClass_()%></td>
				<td><%=teacher.getSubject()%></td>
				<td><%=teacher.getSection()%></td>
				<td><%=teacher.getQualifications()%></td>
				<td><%=teacher.getGender()%></td>
				<td>
					<form method="POST" action="GetTeacherServlet">
						<input type="hidden" name="teacherID"
							value="<%=teacher.getTeacherID()%>" /> <input type="submit"
							value="Select Teacher" class="select-button" />
					</form>
				</td>
			</tr>
			<%
				}
			%>

		</table>

		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>