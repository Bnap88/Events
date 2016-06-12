<%@include file="/WEB-INF/jsp/header.jsp" %>

<div class="container">
	<div class="row">
		<div class="col-lg-4 col-lg-offset-4 col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-12">
			<h2>Create Account</h2>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-4 col-lg-offset-4 col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-12">
			<form action="register" method="POST" role="form">
				<div class="form-group">
					<label for="user-name">Username:</label>
					<input type="text" class="form-control" name="accountUsername" />  
				</div>
				<div class="form-group">
					<label for="email">Email:</label>
					<input type="text" class="form-control" name="accountEmail" />  
				</div>
				<div class="form-group">
					<label for="password">Password:</label>
					<input type="password" class="form-control" name="accountPassword" />
				</div>
				<div class="form-group">
					<label for="password">Confirm Password:</label>
					<input type="password" class="form-control" name="passwordMatch" />
				</div>
				<c:choose>
					<c:when test="${ requestScope.createFailed != null && requestScope.createFailed == true }">
						<p style="color: red;">You must fill out all of the fields!</p>
					</c:when>
					<c:when test="${ requestScope.duplicateName != null && requestScope.duplicateName == true }">
						<p style="color: red;">Account Name Already Exists!</p>
					</c:when>
				</c:choose>
				<button type="submit" class="btn btn-primary">Create</button>
			</form>
		</div>
	</div>
</div>
<c:set var="script" value="/resources/js/registrationValidation.js"></c:set>

<%@include file="/WEB-INF/jsp/footer.jsp" %>