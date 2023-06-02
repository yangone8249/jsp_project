<%@page import="model.PersonVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL choose 연습</title>
</head>
<body>
	<!-- model 안에 PersonVO class 생성,,  멤버변수는 name, age만 추가하기
		생성자 getter/setter만 추가하기-->
	<!-- EL 방식으로 name, age를 출력 -->
	
	<% 
		PersonVO p = new PersonVO("양휘원", 24);
		request.setAttribute("p", p);
	%>
	${p.name }
	${p.age }
	<br>
	<hr>
	
	<c:if test="${pvo.age >= 20 }">
		나이가 20살 이상이면 나오는 글자 <br>
		${pvo.name }은 성인입니다.
	</c:if>
	<c:choose>
		<c:when test=""></c:when>
		<c:when test=""></c:when>
		<c:when test=""></c:when>
		<c:when test=""></c:when>
		<c:otherwise></c:otherwise>
	</c:choose>
</body>
</html>