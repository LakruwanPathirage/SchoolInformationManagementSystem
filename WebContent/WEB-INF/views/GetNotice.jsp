<!--IT18062816 -->
<!--M.G.R.Wijethilaka -->




<%@page import="com.sims.model.Notice"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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

	
	
	<h2 class="h2">Get Notice Page</h2>
	
	<br>
	<br>
	<%
		Notice notice = (Notice) request.getAttribute("notice");
	%>
	
		<form method="POST" action="UpdateNoticeServlet">
		<table>
			<tr>
				<td>Notice ID</td>
				<td><input type="text" name="noticeID" disabled="disabled"
					value="<%=notice.getNoticeID()%>" /></td>
			</tr>
			<tr>
				<td>Notice Name</td>
				<td><input type="text" name="noticeName"
					value="<%=notice.getNoticeName()%>" /></td>
			</tr>
			<tr>
				<td>Teacher ID</td>
				<td><input type="text" name="teacherID"
					value="<%=notice.getTeacherID()%>" /></td>
			</tr>
			<tr>
				<td>Teacher Name</td>
				<td><input type="text" name="TeacherName"
					value="<%=notice.getTeacherName()%>" /></td>
			</tr>
			<tr>
				<td>Grade & Class</td>
				<td><input type="text" name="getGrade_class"
					value="<%=notice.getGrade_class()%>" /></td>
			</tr>
			<tr>
				<td>Notice</td>
				<td><input type="text" name="Notice_des"
					value="<%=notice.getNotice_des()%>" /></td>
			</tr>
		
			<tr>
				<td colspan="2"><input type="hidden" name="noticeID"
					value="<%=notice.getNoticeID()%>" /> <input type="submit"
					value="Update Notice" class="update-button"/></td>
			</tr>
		</table>
	</form>

	<table>
		<tr>
			<td colspan="2">
				<form method="POST" action="DeleteNoticeServlet">
					<input type="hidden" name="noticeID"
						value="<%=notice.getNoticeID()%>" /> <input type="submit"
						value="Delete Notice" class="delete-button"/>
				</form>
			</td>
		</tr>
	</table>
	
	
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>