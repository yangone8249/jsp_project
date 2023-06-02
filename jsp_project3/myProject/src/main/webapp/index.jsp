<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
<style type="text/css">
#indexContent{width: 1000px; height: 700px;
    margin:auto;
    text-align: center;
}
#signUpBtn{
	margin-top: 50px;
	width: 150px;
	height: 55px;
	background-color: #919191;
	opacity:0.7;
	border: none;
	font-size: 20px;
	cursor: pointer;
	margin-right: 50px;
}
#signInBtn{
	margin-top: 50px;
	font-size: 20px;
	width: 150px;
	height: 55px;
	background-color: #919191;
	border: none;
	opacity:0.7;
	cursor: pointer;
	margin-left: 50px;
	
}
#signUpBtn:hover{
	opacity:1;
	color: white;
}
#signInBtn:hover{
	opacity:1;
	color: white;
}
#indexTitle{
	font-weight: 500;
}
#titleDiv{
	width: 500px;
	height: 250px;
	margin:auto;
	background-image: url("https://kpoplat.com/wp-content/uploads/2020/06/KAKAO-FRIENDS.jpg");
}
#userDiv{
	margin-left: 300px;
	text-align: left;
}
</style>
</head>
<body>
	<div id="indexContent">
	<div id="titleDiv">
		<h1 id="indexTitle">양휘원 놀이터</h1>
	</div>
	<hr>
	<c:if test="${ses.id ne null}">
	<div id="userDiv">
	사용자 정보<br>
	id : ${ses.id}<br>
	pw : ${ses.password }<br>
	email : ${ses.email }<br>
	age : ${ses.age }<br>
	</div>
	<hr>
	<a href="/brd/writer?id=${ses.id }" ><button type="button">게시글작성</button></a>
	<a href="/brd/page" ><button type="button">게시글목록보기</button></a>
	<a href="/mem/remove?id=${ses.id}" ><button type="button">회원탈퇴</button></a>
	<a href="/mem/logout" ><button type="button">로그아웃</button></a>
		<c:if test="${ses.id eq 'yang' }">
			<a href="/mem/list" ><button type="button">회원리스트</button></a>
		</c:if>
	</c:if>
	
	<c:if test="${ses.id eq null }">
	<a href="/mem/signUp" ><button type="button" id="signUpBtn">회원가입</button></a>
	<a href="/mem/signIn" ><button type="button" id="signInBtn">로그인</button></a>
	</c:if>
	</div>
<script type="text/javascript">
	const loginAccess = "${loginAccess }";
	
	if(loginAccess == '1'){
		alert("로그인 실패");
	}
</script>
</body>
</html>