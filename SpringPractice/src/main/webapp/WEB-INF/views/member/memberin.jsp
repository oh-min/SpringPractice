<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>회원가입</h1>

<form action="/member" method="post">
아이디 <input type="text" name="id">
비밀번호 <input type="text" name="password">
별명 <input type="text" name="name">
<input type="submit" value="가입하기">

</form>


</body>
</html>