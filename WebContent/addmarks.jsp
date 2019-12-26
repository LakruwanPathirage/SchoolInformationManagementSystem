<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css" href="Style.css" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

 <!-- IT18053838,H.P Sumudu Lakruwan -->
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

<br><br><br><br><br>
		<div class="formdiv"><br>
	<form method="POST" action="addmarksServlet">	<!-- send details to addmarksServlet via user form -->
		<table>

			<tr>
				<td>Student ID</td>
				<td><input type="text" name="studentId" /></td>	<!--Input  student id to input form-->
			</tr>
			<tr>
				<td>Grade</td>
				<td><input type="text" name="grade" /></td>		<!--Input  Grade to input form-->
			</tr>
			<tr>
				<td>Subjects</td>					<!--select subject to form-->
				<td><select name="subject">
  					<option >Sinhala</option>
  					<option >Budhist</option>
  					<option >English</option>
  					<option >Tamil</option>
  					<option >Science</option>
  					<option >Maths</option>
  					<option >History</option>
  					<option >Commerce</option>
  					<option >HealthScience</option>
  					<option >Art</option>
			</select></td>
			</tr>
			<tr>
				<td>Marks</td>				<!-- Input Marks to input field -->
				<td><input type="text" name="marks" /></td>
			</tr>
			
			
			
			
			<tr>
				<td ><button type="submit">Add Marks</button> </td>		<!--Add Marks Button -->
			</tr>
			<tr>	
				<td colspan="2"><input type="reset" value="Reset" class="reset-button" /></td>	<!-- Reset Button -->
			</tr>
		</table>
	</form><br>
	</div>
	<br><br><br><br><br>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>	
	
</body>
</html>