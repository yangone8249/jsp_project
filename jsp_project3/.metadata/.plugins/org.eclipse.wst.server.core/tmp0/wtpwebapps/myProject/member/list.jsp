<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list Page</title>
<style type="text/css">
#listContent{width: 1000px; height: 700px;
    margin:auto;
    text-align: center;
}
#listTitle{
	font-weight: 500;

}
#titleDiv{
	width: 500px;
	height: 250px;
	margin:auto;
	background-image: url("https://kpoplat.com/wp-content/uploads/2020/06/KAKAO-FRIENDS.jpg");
}
#tableList{
	margin: auto;
	border-collapse : collapse;
	
	width: 100%;
}
#titleTable{
	border-top:none;
	border-left:none;
	border-right:none;
}
tr{ border: 1px solid black; height: 60px;}
</style>
</head>
<body>
	<div id="listContent">
	
	<div id="titleDiv">
	<h1 id="listTitle">회원리스트</h1>
	</div>
	<hr>
	<table id="tableList">
		<tr id="titleTable">
			<td>순번</td>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이메일</td>
			<td>나이</td>
			<td>회원가입일자</td>
			<td>마지막로그인</td>
		</tr>
		<c:forEach items="${list }" var="list">
			<tr>
				<td>${list.num }</td>
				<td>${list.id }</td>
				<td>${list.password }</td>
				<td>${list.email }</td>
				<td>${list.age }</td>
				<td>${list.regdate }</td>
				<td>${list.lastLogin }</td>
			</tr>
		
		</c:forEach>
	</table>
	<a href="/mem/index"><button>메인으로</button></a>
	</div>
</body>
</html>