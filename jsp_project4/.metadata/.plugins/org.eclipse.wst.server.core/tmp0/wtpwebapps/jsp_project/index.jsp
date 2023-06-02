<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
<h1>Index Page</h1>

<c:if test="${ses.id ne null }">
${ses.id }님이 login 하였습니다. <br>
${ses.id }님은 ${ses.age}세입니다. <br>
계정생성일 : ${ses.reg_date }<br>
마지막 접속 : ${ses.last_login }<br>

<a href="/mem/modify"><button>회원정보수정</button></a>
<a href="/mem/remove"><button>회원탈퇴</button></a>

<br>
<a href="/brd/register"><button>게시글 작성</button></a>
</c:if>

<a href="/brd/list"><button>게시글 보기</button></a>
<a href="/mem/join"><button>join</button></a>
<a href="/mem/list"><button>list</button></a>
<c:if test="${ses.id eq null }">
<a href="/mem/login"><button>login</button></a>
</c:if>
<c:if test="${ses.id ne null }">
<a href="/mem/logout"><button>logout</button></a>
</c:if>

<script type="text/javascript">
const msg_login = `<c:out value="${msg_login}" />`;
console.log(msg_login);
if(msg_login === '0'){
	alert('로그인 정보가 올바르지 않습니다.');
}
</script>
</body>
</html>