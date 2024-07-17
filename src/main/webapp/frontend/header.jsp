<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row justify-content-center">
	<div class="col-md-8">
	<a href="${pageContext.request.contextPath}/">
	<img alt="BookStoreLogo" src="images/BookStoreLogo.png" class="img-fluid"/> <br/><br/>
	</a>
	</div>
</div>

<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #0d47a1;">
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#topNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	
	<div class="collapse navbar-collapse" id="topNavbar">
		<form action="search" method="get" class="form-inline mr-auto">
			<input type="search" name="keyword" class="form-control mr-sm-2 my-1 ml-2" placeholder="Keyword"/> &nbsp;
			<input type="submit" value="Search" class="btn btn-outline-light mt-1 ml-2"/>
		</form>
		<ul class="navbar-nav ml-auto mr-4">
			<c:if test="${loggedCustomer == null}">
				<li class="nav-item">
					<a href="login" class="nav-link text-white">Sign In</a>
				</li>
				<li class="nav-item">
					<a href="register" class="nav-link text-white">Register</a>
				</li>
			</c:if>
			
			<c:if test="${loggedCustomer != null}">
				<li class="nav-item">
					<a href="view_profile" class="nav-link text-white">Welcome, ${loggedCustomer.fullname}</a>
				</li>
				<li class="nav-item">
					<a href="view_orders" class="nav-link text-white">My Orders</a>
				</li>
				<li class="nav-item">
					<a href="logout" class="nav-link text-white">Logout</a>
				</li>
			</c:if>	
			
			<li class="nav-item">
				<a href="view_cart" class="nav-link text-white">Cart</a>
			</li>
		</ul>
	</div>
</nav>
	
<div>&nbsp;</div>

<div class="row justify-content-center">
	<c:forEach var="category" items="${listCategory}" varStatus="status">
		<a href="view_category?id=${category.categoryId}">
			<font size="+1"><b><c:out value="${category.name}" /></b></font> 
		</a>
		<c:if test="${not status.last}">
			&nbsp; | &nbsp;
		</c:if>
	</c:forEach>
</div>
