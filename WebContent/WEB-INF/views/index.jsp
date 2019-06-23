<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<title>Project Review</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="./assets/css/main.css"/>
		<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath }/images/Teamlogo.ico" />
		<style type="text/css"> #main{margin-top: 73px;} </style>
	</head>
	<body>

<%@include file = "./temp/header.jsp" %>
		<div id="page-wrapper">

			<!-- Banner -->
			<div class="container" style="padding-top:4em;">

							<div class="slide">
									<h2 style="text-align: center;">UDK</h2>
									 <input type="radio" name="pos" id="pos1" checked>
									    <input type="radio" name="pos" id="pos2">
									    <input type="radio" name="pos" id="pos3">
									    <input type="radio" name="pos" id="pos4">
									    <ul style="text-align: center;">
									      <li><a href="#"><img src="./images/banner1.jpg" alt="" style="height: 100%"/></a></li>
									      <li><a href="#"><img src="./images/banner2.jpg" alt="" style="height: 100%"/></a></li>
									      <li><a href="#"><img src="./images/banner3.jpg" alt="" style="height: 100%"/></a></li>
									      <li><a href="#"><img src="./images/banner4.jpg" alt="" style="height: 100%"/></a></li>
									    </ul>
									    <p class="bullet">
									      <label for="pos1">1</label>
									      <label for="pos2">2</label>
									      <label for="pos3">3</label>
									      <label for="pos4">4</label>
									    </p>
								</div>

			</div>
			<!-- Main -->
				<div id="main">
					<div class="container">
						<div class="row main-row">
							<div class="col-6 col-12-medium">

								<section>
									<h2>SHOP</h2>
									<p></p>
									<ul class="big-image-list">
										<li>
											<a href="#"><img src="./images/galaxy-s10-5g.jpg" alt="" class="left" /></a>
											<h3>갤럭시 S10 5G</h3>
											<p>완벽에 가까워진 새로운 디자인.	정교한 레이저 가공, 온 스크린 지문 인식 그리고 다이내믹 아몰레드를 탑재한 가장 혁신적인 시네마틱 인피니티
											<br>디스플레이가 탄생했습니다.</p>
										</li>
										<li>
											<a href="#"><img src="./images/samlaptop.jpg" alt="laptop" class="left" /></a>
											<h3>삼성 노트북9 Always</h3>
											<p>충전은빠르게 사용은 여유롭게<br>
											 <strong>대용량배터리 75Wh 배터리</strong><br>
											최신8세대 인텔CPU + UFS + GIGA WI-FI<br>
											<strong>최첨단 기술 탑재</strong>
											</p>
										</li>
										<li>
											<a href="#"><img src="./images/iphone.jpg" alt="" class="left" /></a>
											<h3>IPhone XR</h3>
											<p>전면 화면 디자인.iPhone 중 가장 긴 배터리 사용시간. <strong>놀랍도록 빠른 성능. 
											생활 방수 기능.</strong><br>
											 스튜디오급 사진 및 4K 동영상 촬영 기능. <br>
											 더욱 <strong>안전</strong>해진 Face ID까지. </p>
										</li>
									</ul>
								</section>
							</div>
							
							<div class="col-4 col-6-medium col-12-small">

								<section>
									<h2>커뮤니티</h2>
									<ul class="small-image-list">
										<li>
											<a href="#"><img src="./images/pic2.jpg" alt="" class="left" /></a>
											<h4>커뮤니티 첫번째 글</h4>
											<p>Varius nibh. Suspendisse vitae magna eget et amet mollis justo facilisis amet quis.</p>
										</li>
										<li>
											<a href="#"><img src="./images/pic01.jpg" alt="" class="left" /></a>
											<h4>커뮤니티 두번째 글</h4>
											<p>Vitae magna eget odio amet mollis justo facilisis amet quis. Sed sagittis consequat.</p>
										</li>
										<li>
											<a href="#"><img src="./images/pic3.jpg" alt="" class="left" /></a>
											<h4>커뮤니티 세번째 글</h4>
											<p>Vitae magna eget odio amet mollis justo facilisis amet quis. Sed sagittis consequat.</p>
										</li>
									</ul>
								</section>
								<section>
									<h2>리뷰</h2>
									<div>
										<div class="row">
											<div class="col-6 col-12-small">
												<ul class="link-list">
													<li><a href="#">첫번째 리뷰 글</a></li>
													<li><a href="#">두번째 리뷰 글</a></li>
													<li><a href="#">세번째 리뷰 글</a></li>
													<li><a href="#">네번째 리뷰 글</a></li>
													<li><a href="#">다섯번째 리뷰 글</a></li>
												</ul>
											</div>
											<div class="col-6 col-12-small">
												<ul class="link-list">
													<li><a href="#">여섯번째 리뷰 글</a></li>
													<li><a href="#">일곱번째 리뷰 글</a></li>
													<li><a href="#">여덟번째 리뷰 글</a></li>
													<li><a href="#">아홉번째 리뷰 글</a></li>
													<li><a href="#">열번째 리뷰 글</a></li>
												</ul>
											</div>
										</div>
									</div>
								</section>

							</div>
							<div class="col-4 col-6-medium col-12-small">


							</div>

							

							</div>
						</div>
					</div>
				</div>

<%@include file="./temp/footer.jsp" %>


		


		<!-- Scripts -->
			<script src="./assets/js/jquery.min.js"></script>
			<script src="./assets/js/browser.min.js"></script>
			<script src="./assets/js/breakpoints.min.js"></script>
			<script src="./assets/js/util.js"></script>
			<script src="./assets/js/main.js"></script>


	</body>
</html>