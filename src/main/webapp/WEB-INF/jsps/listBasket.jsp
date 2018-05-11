<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">
<head>
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
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/js/styles/bootstrap4/popper.js"></script>
<script src="/js/styles/bootstrap4/bootstrap.min.js"></script>
<script src="/js/plugins/Isotope/isotope.pkgd.min.js"></script>
<script src="/js/plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="/js/plugins/easing/easing.js"></script>
<script src="/js/custom.js"></script>
<script src="/js/main.js"></script>
<script src="/js/jquery.loadTemplate.js"></script>
</head>

<body>
	<div class="super_container">

		<!-- Header -->

		<header class="header trans_300">

			<!-- Top Navigation -->

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
											<li><a href="/?lang=en">English</a></li>
											<li><a href="/?lang=hu">Magyar</a></li>
										</ul></li>

									<c:if test="${not empty sessionScope.user.username   }">
										<li class="account" style="color: #b5aec4;">${ sessionScope.user.username }</li>
										<li class="account" style="color: #b5aec4;"><a
											href="/log-out"><spring:message code="log-out" /></a></li>
									</c:if>
									<c:if test="${empty  sessionScope.user.username   }">
										<li class="account"><a href="#"> <spring:message
													code="myaccount" /> <i class="fa fa-angle-down"></i>
										</a>
											<ul class="account_selection">
												<li><a href="/log-in"><i class="fa fa-sign-in"
														aria-hidden="true"></i> <spring:message code="log-in" /></a></li>
												<li><a href="#"><i class="fa fa-user-plus"
														aria-hidden="true"></i> <spring:message code="register" /></a></li>
											</ul></li>
									</c:if>
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
									<li><a href="#"><i class="fa fa-user"
											aria-hidden="true"></i></a></li>
									<li class="checkout"><a href="#"> <i
											class="fa fa-shopping-cart" aria-hidden="true"></i> <span
											id="checkout_items" class="checkout_items">${sessionScope.elementSize}</span>
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
							<li><a href="/?lang=en">English</a></li>
							<li><a href="/?lang=hu">Magyar</a></li>
						</ul></li>
					<c:if test="${not empty sessionScope.user.username   }">
						<li class="account" style="color: #b5aec4;">${ sessionScope.user.username }</li>
						<li class="account" style="color: #b5aec4;"><a
							href="/log-out"><spring:message code="log-out" /></a></li>
					</c:if>
					<c:if test="${empty  sessionScope.user.username   }">
						<li class="account"><a href="#"> <spring:message
									code="myaccount" /> <i class="fa fa-angle-down"></i>
						</a>
							<ul class="account_selection">
								<li><a href="/log-in"><i class="fa fa-sign-in"
										aria-hidden="true"></i> <spring:message code="log-in" /></a></li>
								<li><a href="#"><i class="fa fa-user-plus"
										aria-hidden="true"></i> <spring:message code="register" /></a></li>
							</ul></li>
					</c:if>
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

		<!-- Slider -->

		<div class="main_slider"
			style="background-image: url(images/slider_1.jpg)">
			<div class="container fill_height">
				<div class="row align-items-center fill_height">
					<div class="col">
						<div class="main_slider_content">
							<h6>Spring / Summer Collection 2017</h6>
							<h1>Get up to 30% Off New Arrivals</h1>
							<div class="red_button shop_now_button">
								<a href="#">shop now</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<table id="cart" class="table table-hover table-condensed">
			<thead>
				<tr>
					<th style="width: 50%">Product</th>
					<th style="width: 10%">Price</th>
					<th style="width: 8%">Quantity</th>
					<th style="width: 22%" class="text-center">Subtotal</th>
					<th style="width: 10%"></th>
				</tr>
			</thead>
			<script type="text/html" id="template">
			<tr>
						<td data-th="Product">
							<div class="row">
								<div class="col-sm-2 hidden-xs">
									<img  data-src="cartElement.product.img1"
										alt="..." class="img-responsive" />
								</div>
								<div class="col-sm-10">
									<h4 class="nomargin" data-content="cartElement.product.name">
										
									</h4>
									<p data-content="cartElement.product.description">
										
									</p>
								</div>
							</div>
						</td>
						<td data-th="Price" data-content="cartElement.product.price"></td>
						<td data-th="Quantity"><input type="number" min="1" data-id="cartElement.product.id"
							
							class="form-control text-center" data-value="cartElement.quantity"
							></td>
						<td data-th="Subtotal" class="text-center" data-content="price"></td>

						<td class="actions" data-th="">
							<button class="btn btn-info btn-sm refresh" data-value="cartElement.product.id" >
								<i class="fa fa-refresh"></i>
							</button>
							<button class="btn btn-danger btn-sm delete" data-value="cartElement.product.id" >
								<i class="fa fa-trash-o"></i>
							</button>
						</td>
					</tr>
			
					</script>

			<tbody id="cart-table-body">


				<c:forEach var="cart" items="${basket}">
					<tr>
						<td data-th="Product">
							<div class="row">
								<div class="col-sm-2 hidden-xs">
									<img src="<c:out value="${cart.cartElement.product.img1}" />"
										alt="..." class="img-responsive" />
								</div>
								<div class="col-sm-10">
									<h4 class="nomargin">
										<c:out value="${cart.cartElement.product.name}" />
									</h4>
									<p>
										<c:out value="${cart.cartElement.product.description}" />
									</p>
								</div>
							</div>
						</td>
						<td data-th="Price"><c:out
								value="${cart.cartElement.product.price}" /></td>
						<td data-th="Quantity"><input type="number" min="1"
							id="${cart.cartElement.product.id }"
							class="form-control text-center"
							value="${cart.cartElement.quantity}"></td>
						<td data-th="Subtotal" class="text-center"><c:out
								value="${cart.price}" /></td>

						<td class="actions" data-th="">
							<button class="btn btn-info btn-sm refresh"
								value="${cart.cartElement.product.id }">
								<i class="fa fa-refresh"></i>
							</button>
							<button class="btn btn-danger btn-sm delete"
								value="${cart.cartElement.product.id }">
								<i class="fa fa-trash-o"></i>
							</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>


			<tfoot>
				<tr>
					<td><a href="/" class="btn btn-warning"><i
							class="fa fa-angle-left"></i> Continue Shopping</a></td>
					<td colspan="2" class="hidden-xs"></td>

					<td data-th="Subtotal" class="text-center"><strong><c:if
								test="${offer}">régi ár ${ (fullPrice).intValue() }  kedvezmény </c:if>Total
							<c:out value="${discountPrice}" /> </strong></td>
					<td><a href="#" class="btn btn-success btn-block">Checkout
							<i class="fa fa-angle-right"></i>
					</a></td>
				</tr>
			</tfoot>
		</table>
</body>
</html>