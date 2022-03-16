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
	<iframe src="http://localhost:8899/model2/header"  scrolling="no" frameborder="0" width="100%" height="150px"></iframe>
	
	
	<div class="content">
		<section class="login">
			<h1>게시판</h1>
			<table class="board_content">
				<tr>					
					<th>제목</th>
					<td>${board.btitle }</td>					
				</tr>
				<tr>					
					<th>내용</th>
					<td>${board.bcontent }<br><br><br></td>					
				</tr>
				<tr>					
					<th>조회수</th>
					<td>${board.bhit }</td>					
				</tr>
				<tr>					
					<th>작성일자</th>
					<td>${board.bdate }</td>					
				</tr>
				<tr>
					<th>파일명</th>
					<td>
					<c:if test="${board.bfile != null}">
					${board.bfile }
					 <img src="http://localhost:8899/model2/resources/upload/${board.bsfile }" width="200" height="100">
					 </c:if>
					<c:if test="${board.bfile2 != null}">
						${board.bfile2}
					<img src="http://localhost:8899/model2/resources/upload/${board.bsfile2 }" width="200" height="100">
					</c:if>
						<br> <br> <br>
				</tr>
				<tr>
					<th>파일다운로드</th>
					<td>
						<form action="download" method="get" class="file1down">
							<input type="hidden" name="filename" value="${board.bsfile}">
							<input type="submit" value="다운로드-1">
						</form>
					</td>
				</tr>
				<tr>
					<th>파일다운로드</th>
					<td>
						<form action="download" method="get" class="file2down">
							<input type="hidden" name="filename" value="${board.bsfile2}">
							<input type="submit" value="다운로드-2">
						</form>
					</td>
				</tr>
				<tr>
					<td colspan="2"><a href="board_update?bid=${board.bid }">
							<button type="button" class="btn_style3">수정하기</button>
					</a> <a href="board_delete?bid=${board.bid }">
							<button type="button" class="btn_style3">삭제하기</button>
					</a> <a href="board_list">
							<button type="button" class="btn_style3">리스트</button>
					</a> <a href="http://localhost:8899/model2/main">
							<button type="button" class="btn_style3">홈으로</button>
					</a></td>
				</tr>

			</table>
		</section>		
		
	</div>
	
	<!-- footer start -->
	<iframe src="http://localhost:8899/model2/footer"  scrolling="no" frameborder="0" width="100%" height="500px"></iframe>
	<script>
if('${board.bfile}'==''){
	document.querySelector('.file1down > input[type=submit]').setAttribute('disabled','disabled');
}if('${board.bfile2}'==''){
	document.querySelector('.file2down > input[type=submit]').setAttribute('disabled','disabled');
}
</script>
</body>
</html>







