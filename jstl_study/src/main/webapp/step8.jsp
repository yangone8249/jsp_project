<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="model.PersonVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table{border: 1px solid black}
	td{border: 1px solid black}	
</style>
</head>
<body>
<%
	//PersonVO 객체를 이용하여 list에 여러명을 추가하기 (5명)
	// list에 추가 후 request객체에 담아 jsp로 전송하기
	ArrayList<Object> list = new ArrayList<>();
	list.add(new PersonVO("홍길동", 30));
	list.add(new PersonVO("홍길순", 20));
	list.add(new PersonVO("양휘원", 24));
	list.add(new PersonVO("양겨울", 1));	
	list.add(new PersonVO("양미성년", 19));


		request.setAttribute("person", list);	
%>
<table>
	<tr>
		<td>번호</td>
		<td>이름</td>
		<td>나이</td>
		<td>연령대</td>			
	</tr>
<!-- 테이블을 만들기 -->
	<c:forEach items="${requestScope.person }" var="person" varStatus="value">
		<tr>
			<td>${value.count}</td>
			<td>${requestScope.person[value.index].name }</td>
			<td>${requestScope.person[value.index].age }</td>
			<td>
				<c:if test="${person.age < 20 }">
				미성년
				</c:if>
				<c:if test="${person.age >= 20 }">
				성인
				</c:if>
			</td>			
		</tr>
	
	</c:forEach>
</table>


	

</body>
</html>