<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<h1>공지사항 관리</h1>
			<table class="board_content">
				<tr>					
					<td class="admin_notice_bgcolor"><center>제목</center></td>
					<td>이털너스 재미있어요~^^</td>					
				</tr>
				<tr>					
					<td class="admin_notice_bgcolor"><center>내용</center></td>
					<td>마동석 멋있어요~~<br><br><br></td>					
				</tr>
				<tr>					
					<td class="admin_notice_bgcolor"><center>조회수</center></td>
					<td>100</td>					
				</tr>
				<tr>					
					<td class="admin_notice_bgcolor"><center>작성일자</center></td>
					<td>2021/12/02</td>					
				</tr>
				<tr>					
					<td colspan="2">
						<a href="notice_update">
							<button type="button" class="btn_style3">수정하기</button>
						</a>
						<a href="notice_delete">
							<button type="button" class="btn_style3">삭제하기</button>
						</a>
						<a href="notice_list">
							<button type="button" class="btn_style3">리스트</button>
						</a>
						<a href="http://localhost:8899/model2/main">
							<button type="button" class="btn_style3">홈으로</button>
						</a>
					</td>		
				</tr>
				
			</table>
		</section>		
		
	</div>
	
	<!-- footer start -->
	<iframe src="http://localhost:8899/model2/footer"  scrolling="no" frameborder="0" width="100%" height="500px"></iframe>
	
	
</body>
</html>







