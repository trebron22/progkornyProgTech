<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- jQuery load from online -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- jQuery validate load from online -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.js"></script>
<link rel="stylesheet" type="text/css" href="/css/style.css">

<title><spring:message code="title" /></title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Colo Shop Template">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="/css/styles/bootstrap4/bootstrap.min.css">
<link href="/css/plugins/font-awesome-4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="/css/plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css"
	href="/css/plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css"
	href="/css/plugins/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css"
	href="/css/styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="/css/styles/responsive.css">
</head>
<body>

	<div class="super_container">

		<!-- Header -->

		<header class="header trans_300"> <!-- Top Navigation -->

		<div class="top_nav">
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<div class="top_nav_left">
							<spring:message code="shipping" />
						</div>
					</div>
					<div class="col-md-6 text-right">
						<div class="top_nav_right">
							<ul class="top_nav_menu">

								<!-- Currency / Language / My Account -->

								<li class="currency"><a href="#"> <spring:message
											code="currency" /> <i class="fa fa-angle-down"></i>
								</a>
									<ul class="currency_selection">
										<li><a href="/?lang=en">$</a></li>
										<li><a href="/?lang=hu">Ft</a></li>
									</ul></li>
								<li class="language"><a href="#"> <spring:message
											code="language" /> <i class="fa fa-angle-down"></i>
								</a>
									<ul class="language_selection">
										<li><a href="/log-in?lang=en">English</a></li>
										<li><a href="/log-in?lang=hu">Magyar</a></li>
									</ul></li>
								<li class="account"><c:if test="${not empty sessionScope.user.username}">
										
   											 ${ sessionScope.user.username }
 										</c:if> <c:if test="${!not empty sessionScope.user.username}">
										<a href="#"> <spring:message code="myaccount" /> <i
											class="fa fa-angle-down"></i>
										</a>

										<ul class="account_selection">
											<li><a href="#"><i class="fa fa-sign-in"
													aria-hidden="true"></i> <spring:message code="log-in" /></a></li>
											<li><a href="#"><i class="fa fa-user-plus"
													aria-hidden="true"></i> <spring:message code="register" /></a></li>
										</ul>
									</c:if></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Main Navigation -->

		<div class="main_nav_container">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 text-right">
						<div class="logo_container">
							<a href="#">Simple<span>Shop</span></a>
						</div>
						<nav class="navbar">
						<ul class="navbar_menu">
							<li><a href="#"><spring:message code="home" /></a></li>
							<li><a href="#"><spring:message code="shop" /></a></li>
							<li><a href="#"><spring:message code="promotion" /></a></li>
							<li><a href="#"><spring:message code="pages" /></a></li>
							<li><a href="#"><spring:message code="blog" /></a></li>
							<li><a href="contact.html"><spring:message
										code="contact" /></a></li>
						</ul>
						<ul class="navbar_user">
							<li><a href="#"><i class="fa fa-search"
									aria-hidden="true"></i></a></li>
							<li><a href="#"><i class="fa fa-user" aria-hidden="true"></i></a></li>
							<li class="checkout"><a href="#"> <i
									class="fa fa-shopping-cart" aria-hidden="true"></i> <span
									id="checkout_items" class="checkout_items"> ${sessionScope.elementSize} </span>
							</a></li>
						</ul>
						<div class="hamburger_container">
							<i class="fa fa-bars" aria-hidden="true"></i>
						</div>
						</nav>
					</div>
				</div>
			</div>
		</div>

		</header>

		<div class="fs_menu_overlay"></div>
		<div class="hamburger_menu">
			<div class="hamburger_close">
				<i class="fa fa-times" aria-hidden="true"></i>
			</div>
			<div class="hamburger_menu_content text-right">
				<ul class="menu_top_nav">
					<li class="menu_item has-children"><a href="#"> <spring:message
								code="currency" /> <i class="fa fa-angle-down"></i>
					</a>
						<ul class="menu_selection">
							<li><a href="/?lang=en">$</a></li>
							<li><a href="/?lang=hu">Ft</a></li>
						</ul></li>
					<li class="menu_item has-children"><a href="#"><spring:message
								code="language" /> <i class="fa fa-angle-down"></i> </a>
						<ul class="menu_selection">
							<li><a href="/log-in?lang=en">English</a></li>
							<li><a href="/log-in?lang=hu">Magyar</a></li>
						</ul></li>
					<li class="menu_item has-children"><a href="#"> <spring:message
								code="myaccount" /> <i class="fa fa-angle-down"></i>
					</a>
						<ul class="menu_selection">
							<li><a href="#"><i class="fa fa-sign-in"
									aria-hidden="true"></i> <spring:message code="log-in" /></a></li>
							<li><a href="#"><i class="fa fa-user-plus"
									aria-hidden="true"></i> <spring:message code="register" /></a></li>
						</ul></li>
					<li class="menu_item"><a href="#"><spring:message
								code="home" /></a></li>
					<li class="menu_item"><a href="#"><spring:message
								code="shop" /></a></li>
					<li class="menu_item"><a href="#"><spring:message
								code="promotion" /></a></li>
					<li class="menu_item"><a href="#"><spring:message
								code="pages" /></a></li>
					<li class="menu_item"><a href="#"><spring:message
								code="blog" /></a></li>
					<li class="menu_item"><a href="contact.html"><spring:message
								code="contact" /></a></li>
				</ul>
			</div>
		</div>

		<div class="container">

			<div id="loginbox"
				class="mainbox col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3">

				<div class="row">
					<div class="iconmelon">
						<svg viewBox="0 0 32 32"> <g filter=""> <use
							xlink:href="#git"></use> </g> </svg>
					</div>
				</div>

				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="panel-title text-center">
							<spring:message code="formHeader" />
						</div>
					</div>

					<div class="panel-body">

						<form:form name="form" id="form" commandName="user"
							class="form-horizontal" action="register-submit" method="POST">
							<c:if test="${not empty wrongAccesCode}">
								<p class="text-wrong">
									<spring:message code="wrongAcces" />
								<p>
							</c:if>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-user"></i></span>
								<spring:message code="username" var="username" />
								<form:input path="username" type="text" class="form-control"
									name="username" value="" placeholder="${username}" />
								<br />
								<form:errors path="username" cssClass="error" />

							</div>


							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-lock"></i></span>
								<spring:message code="password" var="password" />
								<form:input path="password" type="password" class="form-control"
									name="password" placeholder="${password}" />
								<br />
								<form:errors path="password" cssClass="error" />
							</div>

							<div class="form-group">
								<!-- Button -->
								<div class="col-sm-12 controls">
									<form:button class="btn btn-primary pull-right">
										<i class="glyphicon glyphicon-log-in"></i>
										<spring:message code="button" />
									</form:button>
								</div>
							</div>

						</form:form>

					</div>
				</div>
			</div>
		</div>
		<!-- New Arrivals -->

		<div class="new_arrivals">
			<div class="container">
				<div class="row">
					<div class="col text-center">
						<div class="section_title new_arrivals_title">
							<h2>New Arrivals</h2>
						</div>
					</div>
				</div>
				<div class="row align-items-center">
					<div class="col text-center">
						<div class="new_arrivals_sorting">
							<ul
								class="arrivals_grid_sorting clearfix button-group filters-button-group">
								<li
									class="grid_sorting_button button d-flex flex-column justify-content-center align-items-center active is-checked"
									data-filter="*">all</li>
								<li
									class="grid_sorting_button button d-flex flex-column justify-content-center align-items-center"
									data-filter=".women">women's</li>
								<li
									class="grid_sorting_button button d-flex flex-column justify-content-center align-items-center"
									data-filter=".accessories">accessories</li>
								<li
									class="grid_sorting_button button d-flex flex-column justify-content-center align-items-center"
									data-filter=".men">men's</li>
							</ul>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<div class="product-grid"
							data-isotope='{ "itemSelector": ".product-item", "layoutMode": "fitRows" }'>

							<!-- Product 1 -->
							<c:forEach var="product" items="${sessionScope.products}">
								<div class="product-item ${product.filter}">
									<div class="product discount product_filter">
										<div class="product_image">
											<img src="<c:out value="${product.img1}" />" alt="">
										</div>
										<div class="favorite favorite_left"></div>
										<div
											class="product_bubble product_bubble_right product_bubble_red d-flex flex-column align-items-center">
											<span>-$${590-product.price} </span>
										</div>
										<div class="product_info">
											<h6 class="product_name">
												<a href="single.html"><c:out
														value="${product.description}" /></a>
											</h6>
											<div class="product_price">
												${product.price}<span> $${590-product.price}</span>
											</div>
										</div>
									</div>
									<div class="red_button add_to_cart_button">
										<a href="#">add to cart</a>
									</div>
								</div>

							</c:forEach>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Deal of the week -->

	<div class="deal_ofthe_week">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-6">
					<div class="deal_ofthe_week_img">
						<img src="images/deal_ofthe_week.png" alt="">
					</div>
				</div>
				<div class="col-lg-6 text-right deal_ofthe_week_col">
					<div
						class="deal_ofthe_week_content d-flex flex-column align-items-center float-right">
						<div class="section_title">
							<h2>Deal Of The Week</h2>
						</div>
						<ul class="timer">
							<li
								class="d-inline-flex flex-column justify-content-center align-items-center">
								<div id="day" class="timer_num">03</div>
								<div class="timer_unit">Day</div>
							</li>
							<li
								class="d-inline-flex flex-column justify-content-center align-items-center">
								<div id="hour" class="timer_num">15</div>
								<div class="timer_unit">Hours</div>
							</li>
							<li
								class="d-inline-flex flex-column justify-content-center align-items-center">
								<div id="minute" class="timer_num">45</div>
								<div class="timer_unit">Mins</div>
							</li>
							<li
								class="d-inline-flex flex-column justify-content-center align-items-center">
								<div id="second" class="timer_num">23</div>
								<div class="timer_unit">Sec</div>
							</li>
						</ul>
						<div class="red_button deal_ofthe_week_button">
							<a href="#">shop now</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Best Sellers -->

	<div class="best_sellers">
		<div class="container">
			<div class="row">
				<div class="col text-center">
					<div class="section_title new_arrivals_title">
						<h2>Best Sellers</h2>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<div class="product_slider_container">
						<div class="owl-carousel owl-theme product_slider">

							<!-- Slide 1 -->

							<c:forEach var="product" items="${sessionScope.products}">

								<div class="owl-item product_slider_item">
									<div class="product-item">
										<div class="product discount">
											<div class="product_image">
												<img src="${product.img1}" alt="">
											</div>
											<div class="favorite favorite_left"></div>
											<div
												class="product_bubble product_bubble_right product_bubble_red d-flex flex-column align-items-center">
												<span> -$${590-product.price}</span>
											</div>
											<div class="product_info">
												<h6 class="product_name">
													<a href="single.html">${product.name}</a>
												</h6>
												<div class="product_price">
													${product.price}<span>$${590-product.price}</span>
												</div>
											</div>
										</div>
									</div>
								</div>


							</c:forEach>
							<!-- Footer -->

							<footer class="footer">
							<div class="container">
								<div class="row">
									<div class="col-lg-6">
										<div
											class="footer_nav_container d-flex flex-sm-row flex-column align-items-center justify-content-lg-start justify-content-center text-center">
											<ul class="footer_nav">
												<li><a href="#">Blog</a></li>
												<li><a href="#">FAQs</a></li>
												<li><a href="contact.html">Contact us</a></li>
											</ul>
										</div>
									</div>
									<div class="col-lg-6">
										<div
											class="footer_social d-flex flex-row align-items-center justify-content-lg-end justify-content-center">
											<ul>
												<li><a href="#"><i class="fa fa-facebook"
														aria-hidden="true"></i></a></li>
												<li><a href="#"><i class="fa fa-twitter"
														aria-hidden="true"></i></a></li>
												<li><a href="#"><i class="fa fa-instagram"
														aria-hidden="true"></i></a></li>
												<li><a href="#"><i class="fa fa-skype"
														aria-hidden="true"></i></a></li>
												<li><a href="#"><i class="fa fa-pinterest"
														aria-hidden="true"></i></a></li>
											</ul>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-lg-12">
										<div class="footer_nav_container">
											<div class="cr">
												©2018 All Rights Reserverd. This template is made with <i
													class="fa fa-heart-o" aria-hidden="true"></i> by <a
													href="#">Colorlib</a>
											</div>
										</div>
									</div>
								</div>
							</div>
							</footer>
</body>
<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/js/styles/bootstrap4/popper.js"></script>
<script src="/js/styles/bootstrap4/bootstrap.min.js"></script>
<script src="/js/plugins/Isotope/isotope.pkgd.min.js"></script>
<script src="/js/plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="/js/plugins/easing/easing.js"></script>
<script src="/js/custom.js"></script>
<script>
	//could good to add jstl fmt to external js
	//it is important to add jstl:fmt to js because of add jstl to external js doesnot work
	var ruleUsername = '<spring:message code="ruleUsername" />';
	var rulePassword = '<spring:message code="rulePassword" />';
</script>
<script type="text/javascript" src="/js/main.js"></script>
</html>