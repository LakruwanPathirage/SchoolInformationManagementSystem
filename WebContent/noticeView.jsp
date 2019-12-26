<!--IT18062816 -->
<!--M.G.R.Wijethilaka -->


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="Style.css" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta charset="ISO-8859-1">
<title>Add Notice</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

	</br>
	</br>
		<div class="formdiv">
		<h2 class="h2">Add Notice</h2>

		Enter the notice for all student in the school. <br> <br>

		<form method="POST" action="AddNoticesServlet">
			<table>

				<tr>
					<td>Notice id</td>
					<td><input type="text" name="noticeID" /></td>
				</tr>

				<tr>
					<td>Notice Name</td>
					<td><input type="text" name="noticeName" /></td>
				</tr>
				<tr>
					<td>Teacher ID</td>
					<td><input type="text" name="teacherID" /></td>
				</tr>
				<tr>
					<td>Teacher Name</td>
					<td><input type="text" name="teacherName" /></td>
				</tr>
				<tr>
					<td>Grade &Class</td>
					<td><select name=grade_class>
							<option>Grade 1-A</option>
							<option>Grade 1-B</option>
							<option>Grade 1-C</option>
							<option>Grade 1-D</option>

							<option>Grade 2-A</option>
							<option>Grade 2-B</option>
							<option>Grade 2-C</option>
							<option>Grade 2-D</option>

							<option>Grade 3-A</option>
							<option>Grade 3-B</option>
							<option>Grade 3-C</option>
							<option>Grade 3-D</option>

							<option>Grade 4-A</option>
							<option>Grade 4-B</option>
							<option>Grade 4-C</option>
							<option>Grade 4-D</option>

							<option>Grade 5-A</option>
							<option>Grade 5-B</option>
							<option>Grade 5-C</option>
							<option>Grade 5-D</option>

							<option>Grade 6-A</option>
							<option>Grade 6-B</option>
							<option>Grade 6-C</option>
							<option>Grade 6-D</option>

							<option>Grade 7-A</option>
							<option>Grade 7-B</option>
							<option>Grade 7-C</option>
							<option>Grade 7-D</option>

							<option>Grade 8-A</option>
							<option>Grade 8-B</option>
							<option>Grade 8-C</option>
							<option>Grade 8-D</option>

							<option>Grade 9-A</option>
							<option>Grade 9-B</option>
							<option>Grade 9-C</option>
							<option>Grade 9-D</option>

							<option>Grade 10-A</option>
							<option>Grade 10-B</option>
							<option>Grade 10-C</option>
							<option>Grade 10-D</option>

							<option>Grade 11-A</option>
							<option>Grade 11-B</option>
							<option>Grade 11-C</option>
							<option>Grade 11-D</option>

							<option>Grade 12-A</option>
							<option>Grade 12-B</option>
							<option>Grade 12-C</option>
							<option>Grade 12-D</option>

							<option>Grade 13-A</option>
							<option>Grade 13-B</option>
							<option>Grade 13-C</option>
							<option>Grade 13-D</option>

					</select></td>
				</tr>
				<tr>
					<td>Notice</td>
					<td><textarea rows="10" cols="50" name="notice_des">Enter notice here</textarea></td>
				</tr>


				<tr>
					<td colspan="2"><input type="submit" value="Add Notice"
						class="add-button" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="reset" value="Reset"
						class="add-button" /></td>
				</tr>
			</table>
		</form>
		</div>
	</br>
	</br>

	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>