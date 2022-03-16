<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CGV-게시판</title>
<link href="http://localhost:8899/model2/resources/css/cgv.css" rel="stylesheet">
<script src="http://localhost:8899/model2/resources/js/cgv.js"></script>
</head>
<body>
	<!-- header start -->
	<iframe src="http://localhost:8899/model2/header"  scrolling="no" frameborder="0" width="100%" height="150px"></iframe>
	
	
	<div class="content">
		<section class="login">
			<h1>공지사항 관리</h1>
			<form name="noticeUpdateForm" action="notice_update" method="post">
			<input type="hidden" name="bid" value="${board.bid }">
				<table class="board_update">
					<tr>					
						<td class="admin_notice_bgcolor"><center>제목</center></td>
						<td>
							<input type="text" name="btitle" value="${board.btitle}" id="ntitle">
						</td>					
					</tr>
					<tr>					
						<td class="admin_notice_bgcolor"><center>내용</center></td>
						<td>
							<textarea rows="10" cols="50" name="bcontent">${board.bcontent}</textarea>
						</td>					
					</tr>				
					<tr>					
						<td colspan="2">
							<button type="button" class="btn_style3" onclick="noticeUpdateFormCheck()">수정완료</button>
							<button type="reset" class="btn_style3">다시쓰기</button>
							<a href="notice_content?bid=${board.bid}">
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







