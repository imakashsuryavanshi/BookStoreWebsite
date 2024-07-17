<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row justify-content-center">
	<div class="col-md-8 text-center">
		<a href="${pageContext.request.contextPath}/admin/">
			<img src="../images/BookStoreAdminLogo.png" class="img-fluid" />
		</a>
	</div>
</div>

<div class="row">	
	<div class="col text-center">
		Welcome, <c:out value="${sessionScope.useremail}" /> | <a href="logout">Logout</a>
	</div>
</div>

<div class="row">&nbsp;</div>
	
<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #78909c;">
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#topNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	
	<div class="collapse navbar-collapse justify-content-center" id="topNavbar">
		<ul class="navbar-nav">
			<li class="nav-item text-center mx-2">
				<a href="list_users" class="nav-link" style="color: white;"><img src="../images/user.png" height="70"/><br/>Users</a>
			</li>
			<li class="nav-item text-center mx-2">
				<a href="list_category" class="nav-link" style="color: white;"><img src="../images/category.png" height="70"/><br/>Categories</a>
			</li>			
			<li class="nav-item text-center mx-2">
				<a href="list_books" class="nav-link" style="color: white;"><img src="../images/book.png" height="70"/><br/>Books</a>
			</li>
			<li class="nav-item text-center mx-2">
				<a href="list_customer" class="nav-link" style="color: white;"><img src="../images/customer.png" height="70"/><br/>Customers</a>
			</li>
			<li class="nav-item text-center mx-2">
				<a href="list_review" class="nav-link" style="color: white;"><img src="../images/review.png" height="70"/><br/>Reviews</a>
			</li>
			<li class="nav-item text-center mx-2">
				<a href="list_order" class="nav-link" style="color: white;"><img src="../images/order.png" height="70"/><br/>Orders</a>
			</li>						
		</ul>
	</div>
</nav>