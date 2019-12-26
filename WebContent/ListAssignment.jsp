<%@page import="com.sims.service.AnalyseServiceIMPL"%>
<%@page import="com.sims.service.AnalyseService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sims.model.Assignment"%>

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


<br>
<!-- Display Assignment datails from taking database -->
<a href="assignmentView.jsp"><button class="bt">Back</button></a>
<br><br>

<center>
	<table border="1" cellpadding="10" class="table">
		 <caption><h2>Assignment List</h2></caption>
		
		<!-- create head names of the table --> 
		 <tr>
		 <td>Assignment List</td>
		 <td>Class</td>
		 <td>Description</td>
		 <td>State</td>
		 <td>Select</td>
		 </tr>
		 
		 
		 <!--Display details in tabular format  -->
		 <%
		 AnalyseService service = new AnalyseServiceIMPL();		//create object of AnalyseServiceIMPL to establish database connection
		 ArrayList<Assignment> AssignmentList = service.getAssignmentList();	//getting all details of Assignment in arryList 
		 
		 for(Assignment assignment : AssignmentList ){	//use foreach loop to display 
		 %>
		 <tr>
		 <th><%=assignment.getAssignmentId()%></th>
		 <th><%=assignment.getClass_() %></th>
		 <th><%=assignment.getDescpt() %></th>
		 <th><%=assignment.getState() %></th>
		 <th>
		 
		 <!-- create select button to update and delete records in database -->
		 <form method="post" action="SelectAssignmentServlet">
		 <input type="hidden" name="assignmentID" value="<%=assignment.getAssignmentId()%>"/>
		  <input type="submit" value= "Select Assignment" /> 
		 </th>
		 </form>
		 	
		 </th>	 
		 </tr>
		 <% } %>
	</table>
	
</center>
	
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>	
	
</body>
</html>