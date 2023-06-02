<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 상세 페이지</title>
</head>
<body>
	<h1>detail.jsp</h1>
		<button type="button"><a href="/index.jsp">메인으로 돌아가기</a></button>

	<table>
		<tr>
			<td>
				번호 : ${pvo.pno }
			</td>
		</tr>
		<tr>
			<td>
				상품명 : ${pvo.pname }
			</td>
		</tr>	
		<tr>
			<td>
				가격 : ${pvo.price }
			</td>
		</tr>
		<tr>
			<td>
				등록일자 : ${pvo.regdate }
			</td>
		</tr>
		<tr>
			<td>
				세부내용 : ${pvo.madeby}
			</td>
		</tr>		
	</table>
	<button type="button"><a href="/modify.pd?pno=${pvo.pno }">수정</a></button>
	<button type="button"><a href="/remove.pd?pno=${pvo.pno }">삭제</a></button>
</body>
</html>