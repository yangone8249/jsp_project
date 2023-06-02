<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.CarVO" %>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>EL(Expression Language)</h3>
	<%
		CarVO car = new CarVO("1234", "SM3", 2000);
		// request.setAttribute : request객체에 값을 저장하는 역할을 한다.
		// request.setAttribute("변수명", 값); = request에 해당 값을 저장한다.
		// 반대로 값을 가져올때는 request.getAttribute를 사용한다.
		request.setAttribute("cvo", car);
	%>
	
	<!-- 변수출력 -->
	<strong>1. CarVO의 객체에서 변수 출력</strong> <br>
	<!-- 방법 1. requestScope를 사용한다. -->
	${requestScope.cvo.name } <br>
	
	<!-- 방법 2. requestScope (생략가능) -->
	${cvo.name }, ${cvo.num }, ${cvo.price }<br>
	
	<hr>
	
	<!-- 리스트로 변수 출력 -->
	<%
		ArrayList<CarVO> list = new ArrayList<CarVO>();
		list.add(new CarVO("4567","벤츠",5000));
		session.setAttribute("carList", list);
	%>
	<strong>1. CarVO의 객체에서 변수 출력</strong> <br>
	
	${sessionScope.carList[0].name }
	<hr>
	<%
		HashMap<String, CarVO> map = new HashMap<>();
		map.put("car1", new CarVO("7255", "SM3", 500));
		map.put("car2", new CarVO("2399", "SM5", 1500));
		map.put("car3", new CarVO("5115", "SM7", 2500));
		request.setAttribute("myCar", map.get("car1"));
		request.setAttribute("myCar2", map.get("car2"));
		request.setAttribute("myCar3", map.get("car3"));
	%>
	${myCar.name}<br>
	${myCar2.name}<br>
	${myCar3.name}<br>		
	<hr>
	<a href="step2-1.jsp">step2-1로 이동</a>
	
</body>
</html>