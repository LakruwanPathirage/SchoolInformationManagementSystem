<%@page import="com.sims.model.Marks"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="Style.css" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<!-- IT18053838,H.p Sumudu Lakruwan -->
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
<br>
<a href="marksview.jsp" ><button>Back</button></a>
<br><br><br>
	<%
		Marks mks = (Marks) request.getAttribute("marks");		//fetching values from SelectmarksServlet
	%>
	<div class="formdiv">
	<form method="post" action="UpdatemarksServlet">	<!-- send data to UpdateServlet -->
		<table>											
		
			
			<tr>
				<td>Grade</td>
				<td><input type="text" name="grade" value="<%=mks.getGrade()%>" /></td>			<!-- select grade if neeeded to update -->
			</tr>
			<tr>
				<td>Subjects</td>
				<td><select name="subject">					<!-- select subject if neeeded to update -->
					<option ><%=mks.getSubject()%></option>
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
				<td>Marks</td>						
				<td><input type="text" name="marks" value="<%=mks.getMarks()%>"/></td>		<!-- select marks if neeeded to update -->
			</tr>

		</table>
		<br><br><br>
	
	<input type="hidden" name="studentId"
		value="<%=mks.getStudentId()%>" />


	<button type="submit">Update Marks</button>			<!-- update button -->
		</br></br>

	</form>
	
	<form method="post" action="marksdeletServlet">			<!-- calling marksdeleteServet when clicking Delete Marks button -->
		<input type="hidden" name="studentId"
			value="<%=mks.getStudentId()%>" />
		<button type="submit">Delete Marks</button>			<!-- delete button -->
		</br>
		</br><br>
	</form>
	</div>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>