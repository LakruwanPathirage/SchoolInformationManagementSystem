<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="Style.css" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">


<!-- IT18061512,W.A.A.S Weerathunge -->

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

<br><a href="assignmentView.jsp" ><button>Back</button></a> <br>

	<h1>Add assignment</h1> 
	<form method="post" action="AddAssignmentServlet">           	<!-- getting user input to form and send them in to AddAssignmentServlet -->
		<!--  Assignment name : <input type="text" name="asid" /><br> <br> -->
					
		<select name="class">	<!-- user have to select class from dropdown -->		
			<option>10A</option>
			<option>10B</option>
			<option>9A</option>
			<option>9C</option>
			<option>9B</option>
		</select> <br> <br>

		<textarea rows="10" cols="100" name="description">assignment description</textarea>		<!--user enter Assignment description about Assignment in to text area  -->
		
		<br> <br>

		<button type="submit">Add Assignment</button>		<!-- Button to submit data -->

	</form>
<br><br>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>

</body>
</html>