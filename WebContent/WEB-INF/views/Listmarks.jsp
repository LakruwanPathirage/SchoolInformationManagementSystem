<%@page import="com.sims.service.marksAnalyserviceIMPL"%>
<%@page import="com.sims.service.marksAnalyservice"%>
<%@page import="java.util.ArrayList"%>
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
<br>
<br>
<center>
<div class="formdiv">

	<table border="1" cellpadding="12">
		 <caption><h2>Marks List</h2></caption>
		 
		 <tr>
		 <th>Student Id</th>
		 <th>Grade</th>
		 <th>Marks</th>
		 <th>Subject</th>
		 <th>Select</th>
		 </tr>
		 
		 
		 <%
		 		 	marksAnalyservice service = new marksAnalyserviceIMPL();  //create marksAnalyserviceImpl object
		 		 	ArrayList<Marks> marList = service.getstudentmarks();    //calling getstudentmarks method in marksanalyserviceIMPL
		 		 		
		 		 		 for(Marks  m: marList ){
		 		 			 
		 %>
		 <tr>
		 	<th><%=m.getStudentId() %></th>				<!-- display marks detals using for each loop -->
		 	<th><%=m.getGrade() %></th>
		 	<th><%=m.getMarks() %></th>
		 	<th><%=m.getSubject()%></th>
		 <th> 
		 	<form method="post" action="SelectmarksServlet">	<!-- when click the select marks button directed into SelectmarksServlet -->
		 	<input type="hidden" name="studentId" value="<%=m.getStudentId()%>"/>
		  	<input type="submit" value= "Select marks" /> 
		  	 </form>
		 </th>
		 		 
		 
		 </tr>
		 <% } %>
	</table>
	</div>
	</center>
	
	<br><br>
	
	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>