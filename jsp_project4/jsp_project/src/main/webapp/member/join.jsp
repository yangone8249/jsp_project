<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>
<h1>Join Page</h1>
	<form action="/mem/register" method="post">
		ID : <input type="text" name="id" placeholder="ID"><br>
		Password : <input type="password" name="password" ><br>
		Email : <input type="text" name="email" placeholder="abc@example.com"><br>
		Age : <input type="text" name="age"><br>
		<button type="submit">가입완료</button>
	</form>
</body>
</html>