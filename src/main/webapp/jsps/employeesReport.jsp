<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title> Employees Report Page </title>
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
		<h2 align="center"> Employees Report </h2> <br><br>
        <table class="table table-dark">
        <thead>
            <tr>
                <th scope="col"> ID </th>
                <th scope="col"> NAME </th>
                <th scope="col"> EMAIL </th>
                <th scope="col"> SALARY </th>
                <th scope="col"> DELETE / UPDATE </th>
            </tr>
        </thead>
        <tbody>
          <c:forEach var="employee" items="${employees}">
            <tr>
                <td><c:out value="${employee.id}"/> </td>
                <td><c:out value="${employee.name}"/> </td>
                <td><c:out value="${employee.email}"/> </td>
                <td><c:out value="${employee.salary}"/> </td>
                <td> <a href="/deleteEmployee/${employee.id}"> delete </a> /  <a href="/employeeUpdate/${employee.id}"> update </a></td>
            </tr>
          </c:forEach>
        </tbody>
        </table>


	</div>
</body>
</html>