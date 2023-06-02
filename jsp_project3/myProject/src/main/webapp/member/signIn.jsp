<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signIn Page</title>
</head>
<body>
	<h1>로그인</h1>
	<br><hr>
	<form action="/mem/login" method="post">
	ID : <input type="text" name="id" /><br>
	PW : <input type="password" name="password"/><br>
	<button type="submit">로그인</button>
	</form>
	<a href="/mem/index"><button type="button">메인으로</button></a>
</body>
</html>