<%@ page import="java.time.LocalDateTime"%>
<%@ page import="java.util.*, calendar.model.Event, java.util.Date, java.time.LocalDateTime, calendar.model.Account, calendar.model.viewmodel.EventListing" %>

<%@ include file="/WEB-INF/jsp/header.jsp" %>

<div class="container">
	<c:choose>
		<c:when test="${ empty requestScope.eventsList }">
			<div class="row">
				<div class="col-lg-4 col-lg-offset-4 col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-12">
					<h2>There are no events in the database right now</h2>
				</div>
		   	</div>
		</c:when>
		<c:otherwise>
			<div class="row">
				<div class="col-xs-2">
					<h3 class="text-center">Event Name</h3>
			    </div>
			    <div class="col-xs-2">
					<h3 class="text-center">Street Address</h3>
			    </div>
			    <div class="col-xs-2">
					<h3 class="text-center">City</h3>
			    </div>
			    <div class="col-xs-1">
					<h3 class="text-center">State</h3>
			    </div>
			    <div class="col-xs-2">
					<h3 class="text-center">Time</h3>
			    </div>
			    <div class="col-xs-1">
			  		<h3 class="text-center">Attendees</h3>
			  	</div>
			</div>
			<c:forEach items="${requestScope.eventsList}" var="eventlisting">
				<div class="row">
					<div class="col-xs-2">
					<p class="text-center">${eventlisting.event.eventName}</p>
				    </div>
				    <div class="col-xs-2">
					 <p class="text-center">${eventlisting.event.eventStreetAddress}</p>
				    </div>
				    <div class="col-xs-2">
					 <p class="text-center">${eventlisting.event.eventCity}</p>
				    </div>
				    <div class="col-xs-1">
					 <p class="text-center">${eventlisting.event.eventState}</p>
				    </div>
				    <div class="col-xs-2">
					 <p class="text-center">${eventlisting.event.eventTime}</p>
				    </div>
				    <div class="col-xs-1">
					  	<ul>  	
						  	<c:forEach items="${eventlisting.attendees}" var="attendee">
						  	  <li>${attendee}</li>
						  	</c:forEach>
					  	</ul>
				  	</div>
					<c:if test="${not empty requestScope.loggedIn && requestScope.loggedIn == true }">
						<div class="col-xs-1 col-xs-offset-1">
					  		<form action="events/like" method="POST">
					  			<input type="submit" value="Like" class="btn btn-primary"/>
					  			<input type="hidden" name="eventId" value="${eventlisting.event.eventId}" />
					  		</form>
					  	</div>
					</c:if>
				</div>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</div>

<%@include file="/WEB-INF/jsp/footer.jsp"  %>