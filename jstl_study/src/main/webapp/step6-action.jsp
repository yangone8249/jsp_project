<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	//post 방식의 한글처리(인코딩 설정)
	request.setCharacterEncoding("utF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- form태그에서 따로 지정해주지않으면 무조건 get방식으로 전송된다.
		get : queryString을 달고 URL상에서 이동하는 방식 (보안X)
		post : 데이터를 숨겨서 전송하는 방식이다, (보안이 좋음)
		하지만 post방식으로 전송을하게되면 encoding이 달라지므로 텍스트가 깨질수있다.
	 -->
	<c:forEach items="${paramValues.food }" var="foodName" varStatus="value">
	
		${value.count }. ${paramValues.food[value.index] }
		${foodName }<br>
	</c:forEach>

	<c:forEach begin="1" end="10" var="num">
		${num }<br>
	</c:forEach>
	
</body>
</html>