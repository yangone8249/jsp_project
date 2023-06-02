<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메뉴를 골라주세요.</h1>
	<h3>주문자 : 양휘원</h3>
	<form action="step6-action.jsp" method="post">
		<input type="checkbox" name="food" value="피자">피자
				<input type="checkbox" name="food" value="치킨">치킨
						<input type="checkbox" name="food" value="칼국수">칼국수
								<input type="checkbox" name="food" value="제육">제육
										<input type="checkbox" name="food" value="닭가슴살">닭가슴살
		<input type="submit" value="전송">
	</form>
</body>
</html>