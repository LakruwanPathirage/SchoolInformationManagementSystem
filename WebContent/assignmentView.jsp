
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

</br>
<a href="index.jsp" ><button>Back</button></a>

</br></br></br>
<!--  Button to direct into addassignment.jsp page -->
<a href="addassignment.jsp">
<button type="submit">Add Assignment</button>
</a>
</br></br></br>

<!--  Button to direct into ListAssignment.jsp page -->
<a href="ListAssignment.jsp">
<button type="button">List assignment</button>
</a>
</br></br></br>

<!-- Button to direct in to AnalyseServlet which having Assignment allocation logics -->
<form method="post" action="AnalyseServlet">
<button type="submit">Analyse Assignment</button>
</form>
</br></br></br>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>