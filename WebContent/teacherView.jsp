<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="Style.css" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel = "stylesheet" type = "text/css" href = "Style.css" />
<meta charset="ISO-8859-1">
<title>Add New Teacher Details</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
</br></br>
<div class="formdiv">
<h2 class="h2">Add New Teacher Details</h2>

	   <form method="POST" action="AddTeacherServlet">
		<table>
		
		    <tr>
				<td>Teacher ID :</td>
				<td><input type="text" name="teacherID" /></td>
			</tr>

			<tr>
				<td>Name :</td>
				<td><input type="text" name="teacherName" /></td>
			</tr>
			<tr>
				<td>Address :</td>
				<td><input type="text" name="address" /></td>
			</tr>
			<tr>
				<td>Class :</td>
				<td><input type="text" name="Class" /></td>
			</tr>
			<tr>
				<td>Subject :</td>
				<td><input type="text" name="subject" /></td>
			</tr>
			<tr>
				<td>Section :</td>
				<td><input type="text" name="section" /></td>
			</tr>
			<tr>
				<td>Qualifications :</td>
				<td><input type="text" name="qualification" /></td>
			</tr>
			<tr>
				<td>Gender :</td>
				<td><input type="radio" name="gender" value="male"
					checked="checked" tabindex="1" /> Male</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="radio" name="gender" value="female"
					tabindex="2" /> Female</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add Teacher" class="add-button" /> </td>
			</tr>
			<tr>	
				<td colspan="2"><input type="reset" value="Reset" class="reset-button" /></td>
			</tr>
		</table>
	</form>
	
	<form method="POST" action="ListTeacherServlet">
		<table>
			<tr>
				<td colspan="2"><input type="submit" value="List All Teachers" class="list-button" />
				</td>
			</tr>
		</table>
	</form>
	</div>
	</br></br>
	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>