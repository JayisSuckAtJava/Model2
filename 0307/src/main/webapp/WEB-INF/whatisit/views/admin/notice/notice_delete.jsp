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
			<form name="boardForm" action="" method="get">
				<table class="board_delete">
					<tr>						
						<td>
							<img src="https://previews.123rf.com/images/imagevectors/imagevectors1511/imagevectors151100102/47598474-%EC%82%AD%EC%A0%9C-%EC%95%84%EC%9D%B4%EC%BD%98-%EC%82%AD%EC%A0%9C.jpg"
									>
							<div>정말로 삭제하시겠습니까?</div>
						</td>					
					</tr>									
					<tr>					
						<td>
							<button type="button" class="btn_style3">삭제완료</button>
							<a href="notice_content">
								<button type="button" class="btn_style3">이전페이지</button>
							</a>
							<a href="notice_list">
								<button type="button" class="btn_style3">리스트</button>
							</a>							
						</td>		
					</tr>					
				</table>
			</form>
		</section>		
		
	</div>
	
	<!-- footer start -->
	<iframe src="http://localhost:8899/model2/footer"  scrolling="no" frameborder="0" width="100%" height="500px"></iframe>
		
</body>
</html>







