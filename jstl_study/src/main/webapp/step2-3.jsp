<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL param 연습3</title>
</head>
<body>
	<a href="step2-2.jsp">step2-2로 이동</a><br>
	<!-- 스클립틀릿 방식에서는 넘어오는 parameter값이 문자열로 인식됨.
		age+1의 값을 전달하면 연산불가함. -->
	<h3>스크립틀릿 방식으로 값받기!</h3>
	<%
	request.setAttribute("nickName", request.getParameter("nickName"));
	request.setAttribute("age", request.getParameter("age")+1);
	%>
	${nickName }
	${age }

	<!-- EL 방식은 내부적으로 형변환 (Integer.parseInt())가
		적용되어 연산이 가능하다. -->
	<h3>EL 방식으로 값받기!</h3>
	${param.nickName}
	${param.age+1}	
	<br> <br>
	<hr>
	
	<form action="step2-4.jsp">
		<!-- name이 여러개로 값을 보낸다면, 배열 형태로 전송한다. -->
		<input type="checkbox" name="food" value="삼겹살">삼겹살<br>
		<input type="checkbox" name="food" value="목살">목살<br>
		<input type="submit" value="전송">
	</form>

</body>
</html>