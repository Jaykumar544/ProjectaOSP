<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title> Feedbacks Report Page </title>
	<link href="http://infiniteiotdevices.com/images/logo.png" rel="icon" sizes="16x16" type="image/gif" />
	<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

	<!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<h2 align="center"> Feedbacks Report </h2> <br><br>
        <table class="table table-dark">
        <thead>
            <tr>
                <th scope="col"> ID </th>
                <th scope="col"> NAME </th>
                <th scope="col"> EMAIL </th>
                <th scope="col"> PHONE </th>
                <th scope="col"> MESSAGE </th>
                <th scope="col"> DELETE </th>
            </tr>
        </thead>
        <tbody>
          <c:forEach var="feedback" items="${feedbacks}">
            <tr>
                <td><c:out value="${feedback.id}"/> </td>
                <td><c:out value="${feedback.name}"/> </td>
                <td><c:out value="${feedback.email}"/> </td>
                <td><c:out value="${feedback.phone}"/> </td>
                <td><c:out value="${feedback.message}"/> </td>
                <td> <a href="/deleteFeedback/${feedback.id}"> delete </a> </td>
            </tr>
          </c:forEach>
        </tbody>
        </table>


	</div>
</body>
</html>