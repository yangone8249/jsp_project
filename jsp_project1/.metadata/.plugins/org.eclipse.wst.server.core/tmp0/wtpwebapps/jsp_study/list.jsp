<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
</head>
<body>
	<h1>상품 목록 페이지</h1>
	
	<table>
		<tr>
			<td>상품번호</td>
			<td>상품이름</td>
			<td>등록일</td>
		</tr>
		
		<c:forEach 	items="${list }" var="pvo">
		<tr>
			<td>${pvo.pno }</td>
			<td><a href="detail.pd?pno=${pvo.pno }">${pvo.pname }</a></td>
			<td>${pvo.regdate }</td>
		</tr>
			
		</c:forEach>
	</table>
	<a href="register.pd"><button type="button">상품등록</button> </a>
		<a href="index.pd"><button type="button">메인으로 이동</button> </a>
</body>
</html>