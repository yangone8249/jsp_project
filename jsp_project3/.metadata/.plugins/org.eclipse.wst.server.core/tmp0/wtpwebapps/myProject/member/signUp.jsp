<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signUp Page</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="/mem/join" method="post">
	ID : <input type="text" name="id"><br>
	PW : <input type="password" name="password"><br>
	Email : <input type="email" name="email"><br>
	Age : <input type="text" name="age"><br>
	<button type="submit">회원가입!</button>
	<a href="/index.jsp"><button type="button">뒤로가기</button></a>
	</form>
</body>
</html>