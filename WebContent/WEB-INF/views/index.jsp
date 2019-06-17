<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<title>Project Review</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="./assets/css/main.css"/>
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
									    <ul>
									      <li></li>
									      <li></li>
									      <li></li>
									      <li></li>
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
							<div class="col-4 col-12-medium">

								<section>
									<h2>뭐넣을까요</h2>
									<p>This is <strong>HIHIHI</strong>, a fully responsive HTML5 site template designed by <a href="http://twitter.com/ajlkn">AJ</a> and released for free by <a href="http://html5up.net">HTML5 UP</a>. It features
									a simple, lightweight design, solid HTML5 and CSS3 code, and full responsive support for desktop, tablet, and small displays.</p>
									<footer class="controls">
										<a href="http://html5up.net" class="button">More cool designs ...</a>
									</footer>
								</section>

							</div>
							<div class="col-4 col-6-medium col-12-small">

								<section>
									<h2>커뮤니티</h2>
									<ul class="small-image-list">
										<li>
											<a href="#"><img src="./images/pic2.jpg" alt="" class="left" /></a>
											<h4>Jane Anderson</h4>
											<p>Varius nibh. Suspendisse vitae magna eget et amet mollis justo facilisis amet quis.</p>
										</li>
										<li>
											<a href="#"><img src="./images/pic1.jpg" alt="" class="left" /></a>
											<h4>James Doe</h4>
											<p>Vitae magna eget odio amet mollis justo facilisis amet quis. Sed sagittis consequat.</p>
										</li>
									</ul>
								</section>

							</div>
							<div class="col-4 col-6-medium col-12-small">

								<section>
									<h2>리뷰</h2>
									<div>
										<div class="row">
											<div class="col-6 col-12-small">
												<ul class="link-list">
													<li><a href="#">Sed neque nisi consequat</a></li>
													<li><a href="#">Dapibus sed mattis blandit</a></li>
													<li><a href="#">Quis accumsan lorem</a></li>
													<li><a href="#">Suspendisse varius ipsum</a></li>
													<li><a href="#">Eget et amet consequat</a></li>
												</ul>
											</div>
											<div class="col-6 col-12-small">
												<ul class="link-list">
													<li><a href="#">Quis accumsan lorem</a></li>
													<li><a href="#">Sed neque nisi consequat</a></li>
													<li><a href="#">Eget et amet consequat</a></li>
													<li><a href="#">Dapibus sed mattis blandit</a></li>
													<li><a href="#">Vitae magna sed dolore</a></li>
												</ul>
											</div>
										</div>
									</div>
								</section>

							</div>
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

							</div>
						</div>
					</div>
				</div>

<%@include file="./temp/footer.jsp" %>


		</div>


		<!-- Scripts -->
			<script src="./assets/js/jquery.min.js"></script>
			<script src="./assets/js/browser.min.js"></script>
			<script src="./assets/js/breakpoints.min.js"></script>
			<script src="./assets/js/util.js"></script>
			<script src="./assets/js/main.js"></script>


	</body>
</html>