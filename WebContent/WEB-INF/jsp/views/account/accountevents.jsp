<%@include file="/WEB-INF/jsp/header.jsp" %>
<%@ page import="java.util.*, calendar.model.Event, java.util.Date" %>

<div class="container">
	<div class="row">
		<div class="col-md-12">
			<h2 class="text-center"><b><c:out value="${sessionScope.username}"></c:out>'s Events</b></h2>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6 col-md-offset-2">
			<h3 class="text-center"><b>Created Events</b></h3>
		</div>
	</div>	
	<c:choose>
		<c:when test="${ requestScope.emptyCreatedEvents != null && requestScope.emptyCreateEvents == false }">
			<div class="row">
				<div class="col-md-2">
					<h4 class="text-center">Name</h4>
				</div>
				<div class="col-md-2">
					<h4 class="text-center">Address</h4>
				</div>
				<div class="col-md-2">
					<h4 class="text-center">City</h4>
				</div>
				<div class="col-md-2">
					<h4 class="text-center">State</h4>
				</div>
				<div class="col-md-2">
					<h4 class="text-center">Time</h4>
				</div>
			</div>	
			<c:forEach items="${sessionScope.createdEvents}" var="event">
				<div class="row">
					<div class="col-md-2">
						<p>${event.eventName}</p>
					</div>
					<div class="col-md-2">
						<p>${event.eventaStreetAddress}</p>
					</div>
					<div class="col-md-2">
						<p>${event.eventCity}</p>
					</div>
					<div class="col-md-2">
						<p>${event.eventState}</p>
					</div>
					<div class="col-md-2">
						<p>${event.eventTime}</p>
					</div>
				</div>
			</c:forEach>
		</c:when>
		<c:otherwise>
    	<div class="row">	
  			<div class="col-md-6">
  				<h4 class="text-center">No Created Events</h4>
  			</div>
  		</div>
		</c:otherwise>	
	</c:choose>
	<div class="row">
		<div class="col-md-6 col-md-offset-2">
			<h3 class="text-center"><b>Liked Events</b></h3>
		</div>
	</div>	
	<c:choose>
		<c:when test="${requestScope.emptyLikedEvents != null  && requestScope.emptyLikedEvents == false }">
			<div class="row">
				<div class="col-md-2">
					<h4 class="text-center">Name</h4>
				</div>
				<div class="col-md-2">
					<h4 class="text-center">Address</h4>
				</div>
				<div class="col-md-2">
					<h4 class="text-center">City</h4>
				</div>
				<div class="col-md-2">
					<h4 class="text-center">State</h4>
				</div>
				<div class="col-md-2">
					<h4 class="text-center">Time</h4>
				</div>
			</div>	
			<c:forEach items="${sessionScope.likedEvents}" var="event">
				<div class="row">
					<div class="col-md-2">
						<p>${event.eventName}</p>
					</div>
					<div class="col-md-2">
						<p>${event.eventStreetAddress}</p>
					</div>
					<div class="col-md-2">
						<p>${event.eventCity}</p>
					</div>
					<div class="col-md-2">
						<p>${event.eventState}</p>
					</div>
					<div class="col-md-2">
						<p>${event.eventTime}</p>
					</div>
				</div>
			</c:forEach>
		</c:when>
		<c:otherwise>
		 	<div class="row">
	   			<div class="col-md-6">
	   				<h4 class="text-center">No Liked Events</h4>
	   			</div>
	   		</div>
 		</c:otherwise>
	</c:choose>
	
</div>

<%@include file="/WEB-INF/jsp/footer.jsp" %>