<%@include file="/WEB-INF/jsp/header.jspf" %>

<div class="container">
	<div class="row">
		<div class="col-lg-4 col-lg-offset-4 col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-12">
			<h2>Log in to Social Calendar</h2>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-4 col-lg-offset-4 col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-12">
			<form:form action="login" modelAttribute="loginForm" method="post" role="form">
				<div class="form-group">
					<label for="account-name">Account Name:</label>
					<input type="text" class="form-control" name="accountUsername"> 
				</div>
				<div class="form-group">
					<label for="password">Password:</label>
					<input type="password" class="form-control" name="accountPassword"> 
				</div>
				<div class="row">
					<div class="col-md-6 col-sm-6 col-xs-6">
						<button type="submit" class="btn btn-primary btn-block">Login</button>
					</div>
				</div>
			</form:form>
			<br /> 
			<div class="row">
				<div class="col-md-6 col-sm-6 col-xs-6">
					<a href="<c:url value='register'>
				         </c:url>" class="btn btn-primary btn-block">Create Account</a><br /> 
				</div>
			</div>
<% 
	if ( request.getAttribute("loginFailed") != null && (Boolean)request.getAttribute("loginFailed") )
	{
%>
					<p style="color: red;">Incorrect username or password!</p>

<%  }  %>
    	</div>  
	</div>
</div>

<% 
	//Set JavaScript files in footer
	String script = null;
%>

<%@include file="/WEB-INF/jsp/footer.jspf" %>