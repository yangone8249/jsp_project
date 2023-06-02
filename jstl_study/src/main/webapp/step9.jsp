<%@page import="model.PersonVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- c:set var="변수" value="지정 값" -->
	<%
		PersonVO p = new PersonVO("홍길동", 24);
		request.setAttribute("pvo", p);
	
	%>
	<!-- 스크립틀릿으로 확인하는 방법 -->
	스크립틀릿방식<br>
		이름 : <%=p.getName() %><br>
		나이 : <%=p.getAge() %>
	<hr>
	
	<%-- EL방식으로 확인하는 방법 --%>
	EL방식<br>
		이름 : ${requestScope.pvo.name }<br>
		나이 : ${requestScope.pvo.age }<br>
	<hr>
		
	<c:set var="person" value="${pvo }"></c:set>
	c:set방식<br>
		이름 : ${person.name }<br>
		나이 : ${person.age }

	
</body>
</html>