<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CGV-공지사항</title>
<link href="http://localhost:8899/model2/resources/css/cgv.css" rel="stylesheet">
<link rel="stylesheet" href="http://localhost:8899/model2/resources/css/am-pagination.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="http://localhost:8899/model2/resources/js/am-pagination.js"></script>
<script>
	$(document).ready(function(){
		
		var pager = jQuery('#ampaginationsm').pagination({
		
		    maxSize: 7,	    		// max page size
		    totals: '${dbCount}',	// total pages	
		    page: '${rpage}',		// initial page		
		    pageSize: '${pageSize}',			// max number items per page
		
		    // custom labels		
		    lastText: '&raquo;&raquo;', 		
		    firstText: '&laquo;&laquo;',		
		    prevText: '&laquo;',		
		    nextText: '&raquo;',
				     
		    btnSize:'sm'	// 'sm'  or 'lg'		
		});
		
		jQuery('#ampaginationsm').on('am.pagination.change',function(e){
			   jQuery('.showlabelsm').text('The selected page no: '+e.page);
	           $(location).attr('href', "http://localhost:8899/model2/notice?rpage="+e.page);         
	    });
		
 	});
</script> 
</head>
<body>
	<!-- header start -->
	<iframe src="http://localhost:8899/model2/header"  scrolling="no" frameborder="0" width="100%" height="150px"></iframe>
	
	
	<div class="content">
		<section class="login">
			<h1>공지사항</h1>
			<table class="notice_list">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>조회수</th>
					<th>작성일자</th>
				</tr>
				<c:forEach var="board" items="${list}">
					<tr>
						<td>${board.rno}</td>
						<td><a href="notice_content?bid=${board.bid}">${board.btitle}</a></td>
						<td>${board.bhit}</td>
						<td>${board.bdate}</td>
					</tr>
				</c:forEach>
				<tr>
					<%-- 페이지 네비게이션 시작 --%>
					<td colspan=4><div id="ampaginationsm"></div></td>
					<%-- 페이지 네비게이션 종료  --%>
				</tr>
			</table>
		</section>

	</div>
	
	<!-- footer start -->
	<iframe src="http://localhost:8899/model2/footer"  scrolling="no" frameborder="0" width="100%" height="500px"></iframe>
	
</body>
</html>







