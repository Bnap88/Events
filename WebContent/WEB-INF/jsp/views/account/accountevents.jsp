<%@include file="/WEB-INF/jsp/header.jsp" %>
<%@ page import="java.util.*, calendar.model.Event, java.util.Date" %>

<div class="container">
	<div class="row">
		<div class="col-xs-12">
			<h2 class="text-center"><b><c:out value="${sessionScope.username}"></c:out>'s Events</b></h2>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<h3 class="text-center"><b>Created Events</b></h3>
		</div>
	</div>	
	<c:choose>
		<c:when test="${ not empty emptyCreatedEvents && emptyCreatedEvents == false }">
			<div class="row">
				<div class="col-xs-2 col-xs-offset-1">
					<h4 class="text-center">Name</h4>
				</div>
				<div class="col-xs-2">
					<h4 class="text-center">Address</h4>
				</div>
				<div class="col-xs-2">
					<h4 class="text-center">City</h4>
				</div>
				<div class="col-xs-2">
					<h4 class="text-center">State</h4>
				</div>
				<div class="col-xs-2">
					<h4 class="text-center">Time</h4>
				</div>
			</div>	
			<c:forEach items="${createdEvents}" var="event">
				<div class="row">
					<div class="col-xs-2 col-xs-offset-1">
						<p>${event.eventName}</p>
					</div>
					<div class="col-xs-2">
						<p>${event.eventStreetAddress}</p>
					</div>
					<div class="col-xs-2">
						<p>${event.eventCity}</p>
					</div>
					<div class="col-xs-2">
						<p>${event.eventState}</p>
					</div>
					<div class="col-xs-2">
						<p>${event.eventTime}</p>
					</div>
					<div class="col-xs-1">
					  	<form action="/events/delete" method="POST">
					  		<input type="submit" value="Delete" class="btn btn-danger"/>
					  		<input type="hidden" name="eventId" value="${event.eventId}" />
					  	</form>
					</div>
				</div>
			</c:forEach>
		</c:when>
		<c:otherwise>
    	<div class="row">	
  			<div class="col-xs-6">
  				<h4 class="text-center">No Created Events</h4>
  			</div>
  		</div>
		</c:otherwise>	
	</c:choose>
	<div class="row">
		<div class="col-xs-12">
			<h3 class="text-center"><b>Liked Events</b></h3>
		</div>
	</div>	
	<c:choose>
		<c:when test="${ not empty emptyLikedEvents  && emptyLikedEvents == false }">
			<div class="row">
				<div class="col-xs-2 col-xs-offset-1">
					<h4 class="text-center">Name</h4>
				</div>
				<div class="col-xs-2">
					<h4 class="text-center">Address</h4>
				</div>
				<div class="col-xs-2">
					<h4 class="text-center">City</h4>
				</div>
				<div class="col-xs-2">
					<h4 class="text-center">State</h4>
				</div>
				<div class="col-xs-2">
					<h4 class="text-center">Time</h4>
				</div>
			</div>	
			<c:forEach items="${likedEvents}" var="event">
				<div class="row">
					<div class="col-xs-2 col-xs-offset-1">
						<p>${event.eventName}</p>
					</div>
					<div class="col-xs-2">
						<p>${event.eventStreetAddress}</p>
					</div>
					<div class="col-xs-2">
						<p>${event.eventCity}</p>
					</div>
					<div class="col-xs-2">
						<p>${event.eventState}</p>
					</div>
					<div class="col-xs-2">
						<p>${event.eventTime}</p>
					</div>
					<div class="col-xs-1">
					  	<form action="/events/unlike" method="POST">
					  		<input type="submit" value="Unlike" class="btn btn-warning"/>
					  		<input type="hidden" name="eventId" value="${event.eventId}" />
					  		<input type="hidden" name="accountId" value="${sessionScope.accountId}" />
					  	</form>
					</div>
				</div>
			</c:forEach>
		</c:when>
		<c:otherwise>
		 	<div class="row">
	   			<div class="col-xs-6">
	   				<h4 class="text-center">No Liked Events</h4>
	   			</div>
	   		</div>
 		</c:otherwise>
	</c:choose>
	
</div>

<%@include file="/WEB-INF/jsp/footer.jsp" %>