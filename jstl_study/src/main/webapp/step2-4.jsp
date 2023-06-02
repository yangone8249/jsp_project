<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL param 연습4</title>
</head>
<body>
	<a href="step2-3.jsp">step2-3로 이동</a><br>	<a href="step3-if.jsp">step3-if로 이동</a><br>
	
	<!-- EL 방식에서 null 값은 출력되지 않는다. -->
	메뉴1 : ${paramValues.food[0] }<br>
	메뉴2 : ${paramValues.food[1] }<br>
</body>
</html>