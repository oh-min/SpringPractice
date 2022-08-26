<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/resources/js/reply.js"></script>
<script type="text/javascript" src="/resources/js/attach.js"></script>
</head>
<body>


	<form method="post">
		<table border="1">
			<tr>
				<td>제목</td> 
				<td><input type="text" value="${detail.title}" name="title">
					<input type="hidden" value="${detail.bno}" name="bno">
				</td>
			</tr>
			
			<tr>
				<td>내용</td> <td><textarea name="content">${detail.content}</textarea></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="수정" formaction="/board/modify"></td>
				<td><input type="submit" value="삭제" formaction="/board/remove"></td>
			</tr>
			
		</table>
	</form>
	<div id="uploadResult">	
		<ul>
			
		</ul>
	</div>
	<div><label>댓글</label></div>
	<div>
		<textarea rows="5" cols="50" id="reply"></textarea>
	</div>
	<div>
		<input id="add" type="button" value="댓글쓰기">
	</div>
	<div id="chat">
		<ul id="replyUL">	
		</ul>
	</div>
	

</body>
</html>