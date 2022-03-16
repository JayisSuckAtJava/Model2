<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CGV</title>
<link href="http://localhost:8899/model2/resources/css/cgv.css" rel="stylesheet">
<script>

	if('${logout_result}' == 'succ'){
		alert("정상적으로 로그아웃 하였습니다.");
	}
	if('${login_result}' == 'succ'){
		alert("로그인에 성공하셨습니다");
	}
	if('${fuck}'=='fuck'){
		alert("뭐해 ㅅㅂ");
	}
	
</script>
</head>
<body>
	<!-- header start -->
	<iframe src="http://localhost:8899/model2/header"  scrolling="no" frameborder="0" width="100%" height="149px"></iframe>
	
	
	<!-- content start  -->
	<div class="content">
		<!-- carousel -->
		<div class="bg_carousel"> <!-- background-image 추가 100% -->
			<div class="carousel">
				<!-- <h3>Carousel 추가부분</h3>-->
				<img src="http://localhost:8899/model2/resources/images/16347931161070.jpg">
			</div>
		</div>		
		<!-- movie selection -->
		<section>
			<div><img src="http://localhost:8899/model2/resources/images/h3_movie_selection.gif"></div>
			<iframe width="710" height="400" src="https://www.youtube.com/embed/SndPCQiu5gs" 
			title="YouTube video player" frameborder="0" 
			allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" 
			allowfullscreen></iframe>
			<img src="http://localhost:8899/model2/resources/images/1201_240x388.jpg">
		</section>
		
		<!-- event -->
		<section>
			<div><img src="http://localhost:8899/model2/resources/images/h3_event.gif"></div>
			<div class="event1">
				<img src="http://localhost:8899/model2/resources/images/16170705205160.jpg">
				<img src="http://localhost:8899/model2/resources/images/16315139087750.jpg">
				<img src="http://localhost:8899/model2/resources/images/16315139088220.jpg">
				<img src="http://localhost:8899/model2/resources/images/16315179619950.jpg">
			</div>
			<div class="event2">
				<img src="http://localhost:8899/model2/resources/images/1109_226x259.jpg">
				<img src="http://localhost:8899/model2/resources/images/main_moviecollage.jpg">
				<img src="http://localhost:8899/model2/resources/images/16258186526120.png">
			</div>
		</section>	
	</div>
	
	<!-- footer start -->
	<iframe src="http://localhost:8899/model2/footer"  scrolling="no" frameborder="0" width="100%" height="500px"></iframe>
		
</body>
</html>







