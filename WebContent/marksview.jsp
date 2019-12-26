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
	<br>
	<a href="index.jsp"><button>Back</button></a>
	</br>
	</br>

	<!-- Buttons are displayed of Addmarks and List Student marks,press by teacher -->
	<div class=Addmarksbutton>
		<a href="addmarks.jsp">
			<button type="submit">Add marks</button>
		</a>
	</div>

	<div class="ListmarkButton">
		<form method="post" action="Listmarks">
			<button type="submit">List student marks</button>
		</form>
	</div>

	<div class=markfooter>
		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	</div>
</body>
</html>