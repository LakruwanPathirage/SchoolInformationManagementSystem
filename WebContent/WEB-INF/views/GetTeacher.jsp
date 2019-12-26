
<%@page import="com.sims.model.Teacher"%>
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
	<br>
	<a href="index.jsp"><button>Back</button></a>
	<br>
	<h2 class="h2">Get Teacher Page</h2>

	SLIIT Teacher Management App for OOP jsp servlet.
	<br>
	<br>
	<%
		Teacher teacher = (Teacher) request.getAttribute("teacher");
	%>

	<form method="POST" action="UpdateTeacherServlet">
		<table>
			<tr>
				<td>Teacher ID</td>
				<td><input type="text" name="teacherID" disabled="disabled"
					value="<%=teacher.getTeacherID()%>" /></td>
			</tr>
			<tr>
				<td>Teacher Name</td>
				<td><input type="text" name="teacherName"
					value="<%=teacher.getName()%>" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address"
					value="<%=teacher.getAddress()%>" /></td>
			</tr>
			<tr>
				<td>Teacher Class</td>
				<td><input type="text" name="Class"
					value="<%=teacher.getClass_()%>" /></td>
			</tr>
			<tr>
				<td>Subject</td>
				<td><input type="text" name="subject"
					value="<%=teacher.getSubject()%>" /></td>
			</tr>
			<tr>
				<td>Section</td>
				<td><input type="text" name="section"
					value="<%=teacher.getSection()%>" /></td>
			</tr>
			<tr>
				<td>Qualifications</td>
				<td><input type="text" name="qualification"
					value="<%=teacher.getQualifications()%>" /></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><input type="radio" name="gender" value="male"
					checked="checked" tabindex="1" /> Male</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="radio" name="gender" value="female"
					tabindex="2" /> Female</td>
			</tr>
			<tr>
				<td colspan="2"><input type="hidden" name="teacherID"
					value="<%=teacher.getTeacherID()%>" /> <input type="submit"
					value="Update Teacher" class="update-button" /></td>
			</tr>
		</table>
	</form>

	<table>
		<tr>
			<td colspan="2">
				<form method="POST" action="DeleteTeacherServlet">
					<input type="hidden" name="teacherID"
						value="<%=teacher.getTeacherID()%>" /> <input type="submit"
						value="Delete Teacher" class="delete-button" />
				</form>
			</td>
		</tr>
	</table>

	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>