<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title> searched proudcts page </title>
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
		<h2 align="center"> Searched Products </h2> <br><br>
        <table class="table table-dark">
        <thead>
            <tr>
                <th scope="col"> ID </th>
                <th scope="col"> NAME </th>
                <th scope="col"> TYPE </th>
                <th scope="col"> BRAND </th>
                <th scope="col"> PRICE </th>
                <th scope="col"> DESCRIPTION </th>
            </tr>
        </thead>
        <tbody>
          <c:forEach var="product" items="${products}">
            <tr>
                <td><c:out value="${product.id}"/> </td>
                <td><c:out value="${product.name}"/> </td>
                <td><c:out value="${product.type}"/> </td>
                <td><c:out value="${product.brand}"/> </td>
                <td><c:out value="${product.price}"/> </td>
                <td><c:out value="${product.description}"/> </td>
            </tr>
          </c:forEach>
        </tbody>
        </table>


	</div>
</body>
</html>