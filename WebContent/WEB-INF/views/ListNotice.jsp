<!--IT18062816 -->
<!--M.G.R.Wijethilaka -->



<%@page import="com.sims.model.Notice"%>
<%@page import="com.sims.service.NoticeServiceImpl"%>
<%@page import="com.sims.service.INoticeService"%>
<%@page import="java.util.ArrayList"%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="Style.css" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta charset="ISO-8859-1">
<title>Notice Managment</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

</br>
<a href="index.jsp" ><button>Back</button></a>

	
	
	<br>
	<br>
	
		  <div align="left">
		<table border="1" cellpadding="12">
		 <caption><h2>List of Notice</h2></caption>
		  <tr>
                <th>Notice ID</th>
                <th>Notice Name</th>
                <th>Teacher ID</th>
                <th>Teacher Name</th>
                <th>Grade & Class</th>
                <th>Notice</th>
            
                <th>Select</th>
            </tr>
            
            <%
            INoticeService iNoticeService = new NoticeServiceImpl();
			ArrayList<Notice> arrayList = iNoticeService.getNotice();
			
			for(Notice notice : arrayList){
			%>
			 <tr>
				<td> <%=notice.getNoticeID() %> </td>
				<td> <%=notice.getNoticeName() %> </td>
				<td> <%=notice.getTeacherID() %> </td>
				<td> <%=notice.getTeacherName() %> </td>
				<td> <%=notice.getGrade_class() %> </td>
				<td> <%=notice.getNotice_des() %> </td>
				
				<td> 
				<form method="POST" action="GetNoticeServlet">
				<input type="hidden" name="noticeID" value="<%=notice.getNoticeID() %>"/>
				 <input type="submit" value= "Select Notice" class="select-button" /> 
				 </form>
				 </td>	
				</tr>			
			<%	
			   }
            %>  
            
		</table>
		</div>
	
	<br><br>
	
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>	

</body>
</html>