<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="Style.css" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

	<div align="center">



		<div class="row">
			<div class="column">


				<div class="card">
					<a href="marksview.jsp"> <img src="image/pic1.jpg" alt="John"
						style="width: 100%">
						<h1>Teacher Marking Portal</h1>
						<p class="title"></p>
					</a>
				</div>




			</div>





			<div class="row">
				<div class="column">

					<div class="card">
						<a href="noticeView.jsp"> <img src="image/pic2.jpg" alt="John"
							style="width: 100%">
							<h1>News and Information</h1>
							<p class="title"></p>
						</a>

					</div>




				</div>




				<div class="row">
					<div class="column">

						<div class="card">
							<a href="teacherView.jsp"> <img src="image/pic3.jpg"
								alt="John" style="width: 100%">
								<h1>Teacher Account Information</h1>
								<p class="title"></p>
							</a>

						</div>




					</div>


					<div class="row">
						<div class="column">

							<div class="card">
								<a href="assignmentView.jsp"> <img src="image/pic4.jpg"
									alt="John" style="width: 100%">
									<h1>Assignment Analyse</h1>
									<p class="title"></p>
								</a>
							</div>




						</div>

					</div>
				</div>




				<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>

</body>
</html>