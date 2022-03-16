<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CGV-게시판</title>
<link href="http://localhost:8899/model2/resources/css/cgv.css" rel="stylesheet">
</head>
<body>
	<!-- header start -->
	<iframe src="http://localhost:8899/model2/header"   scrolling="no" frameborder="0" width="100%" height="150px"></iframe>
	
	
	<div class="content">
		<section class="login">
			<h1>게시판</h1>
			<table class="board_list">
				<tr>
					<td colspan="4">
						<a href="board_write"><button type="button" class="btn_style2">글쓰기</button></a>
					</td>
				</tr>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>조회수</th>
					<th>작성일자</th>
				</tr>
				<c:forEach var="board"  items="${list}">
				<tr>
					<td>${board.rno}</td>
					<td><a href="board_content?bid=${board.bid}">${board.btitle}</a></td>
					<td>${board.bhit}</td>
					<td>${board.bdate}</td>
				</tr>
				</c:forEach>
				<tr>
					<td colspan="4"><< 1  2  3  4  5  >></td>					
				</tr>
			</table>
		</section>		
		
	</div>
	
	<!-- footer start -->
	<iframe src="http://localhost:8899/model2/footer"   scrolling="no" frameborder="0" width="100%" height="500px"></iframe>
	
	
</body>
</html>







