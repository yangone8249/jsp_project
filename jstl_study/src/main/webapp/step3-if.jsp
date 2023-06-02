<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL if</title>
</head>
<body>
	<a href="step2-4.jsp">step2-4로 이동</a><br>	<a href="step4-choose.jsp">step4-choose로 이동</a><br>
	<!-- JSTL if 조건 -->
	<c:if test="true">
		<!-- test 조건이 참일 경우에만 실행한다. -->
		true이므로 실행됨.
	</c:if>
	<!-- Query String 방식 -->
	<a href="step3-if.jsp?age=10&nick=apple">step3-if 다시 호출</a><br>
	<br>
	나이 : ${param.nick}
	이름 : ${param.age }<br>
	
	<!-- 나이가 5보다 크면 출력 -->
</body>
</html>