<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CGV-공지사항</title>
<link href="../resources/css/cgv.css" rel="stylesheet">
</head>
<body>
	<!-- header start -->
	<iframe src="../header"  scrolling="no" frameborder="0" width="100%" height="150px"></iframe>
	
	<div class="content">
		<section class="login">
			<h1>회원 정보</h1>
			<table class="notice_content">
				<tr>					
					<th>아이디</th>
					<td>${detail.id}</td>					
				</tr>
				<tr>					
					<th>비밀번호</th>
					<td>${detail.pass}<br><br><br></td>					
				</tr>
				<tr>					
					<th>이름</th>
					<td>${detail.name}</td>					
				</tr>
				<tr>					
					<th>성별</th>
					<td>${detail.gender}</td>					
				</tr>
				<tr>					
					<th>이메일</th>
					<td>${detail.email}</td>					
				</tr>
				<tr>					
					<th>주소</th>
					<td>${detail.address}</td>					
				</tr>
				<tr>					
					<th>전화번호</th>
					<td>${detail.hp_comp} 사 ${detail.hp_num}</td>					
				</tr>
				<tr>					
					<th>자기소개</th>
					<td>${detail.intro}</td>					
				</tr>
				<tr>					
					<td colspan="2">
					<c:if test="${sessionScope.sid == 'jay'}">
						<a href="member_list">
							<button type="button" class="btn_style3">리스트</button>
						</a>
						</c:if>
						<a href="../main">
							<button type="button" class="btn_style3">홈으로</button>
						</a>
					</td>		
				</tr>
				
			</table>
		</section>		
		
	</div>
	
	<!-- footer start -->
	<iframe src="../footer"  scrolling="no" frameborder="0" width="100%" height="500px"></iframe>
	
</body>
</html>







