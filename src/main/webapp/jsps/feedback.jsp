<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title> Feedback Form</title>

	<style>
                    body {
                        font-family: Arial, sans-serif;
                        background-color: #f4f4f4;
                    }
                    .loginBox {
                        width: 300px;
                        background: #fff;
                        margin: 0 auto;
                        padding: 20px;
                        border-radius: 5px;
                        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                    }
                    h2 {
                        text-align: center;
                    }
                    form {
                        text-align: left;
                    }
                    input[type="text"],
                    input[type="password"],
                    input[type="number"],
                    textarea {
                        width: 100%;
                        padding: 10px;
                        margin-bottom: 15px;
                        border: 1px solid #ccc;
                        border-radius: 5px;
                        box-sizing: border-box;
                    }
                    textarea {
                        height: 100px;
                    }
                    input[type="submit"] {
                        background-color: #4CAF50;
                        color: white;
                        padding: 10px 20px;
                        border: none;
                        border-radius: 5px;
                        cursor: pointer;
                        font-size: 16px;
                    }
                    input[type="submit"]:hover {
                        background-color: #45a049;
                    }
                    p {
                        margin: 0;
                    }
                </style>

</head>
<body>
	<form action="/submitFeedback" method="post">
	    <div class="loginBox">
        		<h2> Feedback form - (Contact us here) </h2>
        		<form>
        			<p>Name</p>
        			<input type="text" name="name" placeholder="Enter Name">
        			<p>Email</p>
        			<input type="text" name="email" placeholder="Enter Email">
        			<p>Phone No </p>
                    <input type="number" name="phone" placeholder="Enter Phone no">
        			<p>Message</p>
        			<textarea name="message" placeholder="Enter message here...">
        			</textarea>
        			<input type="submit" >
        		</form>
        	</div>
	</form>
</body>
</html>