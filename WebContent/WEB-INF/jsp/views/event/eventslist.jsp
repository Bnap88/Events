<%@page import="java.time.LocalDateTime"%>
<%@ page import="java.util.*, calendar.model.Event, java.util.Date, java.time.LocalDateTime, calendar.model.Account, calendar.model.viewmodel.EventListing" %>
<%
    @SuppressWarnings("unchecked")
   List<EventListing> eventsList =
            (List<EventListing>)request.getAttribute("eventsList");
%>
<%@include file="/WEB-INF/jsp/header.jspf" %>
<div class="container">
<%  
	if (eventsList == null || eventsList.size() == 0)
	{
	%>
	<div class="row">
		<div class="col-lg-4 col-lg-offset-4 col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-12">
			<h2>There are no events in the database right now</h2>
		</div>
   	</div>
  <%} 
	else
	{
		%>
	<div class="row">
		<div class="col-md-2">
			<h3 class="text-center">Event Name</h3>
	    </div>
	    <div class="col-md-2">
			<h3 class="text-center">Street Address</h3>
	    </div>
	    <div class="col-md-2">
			<h3 class="text-center">City</h3>
	    </div>
	    <div class="col-md-1">
			<h3 class="text-center">State</h3>
	    </div>
	    <div class="col-md-2">
			<h3 class="text-center">Time</h3>
	    </div>
	    <div class="col-md-1">
	  		<h3 class="text-center">Attendees</h3>
	  	</div>
	</div>
		<% 
		
		for (EventListing event : eventsList)
		{	
			Integer eventId = event.getEvent().getEventId();
			String eventName = event.getEvent().getEventName();
			String eventStreetAddress = event.getEvent().getEventStreetAddress();
			String eventCity = event.getEvent().getEventCity();
			String eventState = event.getEvent().getEventState();
			LocalDateTime dateTime = event.getEvent().getEventTime();
			List<String> attendees = event.getAttendees();
			
			%> 
			<div class="row">
				<div class="col-md-2">
				<p class="text-center"><%= eventName %> </p>
			    </div>
			    <div class="col-md-2">
				 <p class="text-center"><%= eventStreetAddress %> </p>
			    </div>
			    <div class="col-md-2">
				 <p class="text-center"><%= eventCity %> </p>
			    </div>
			    <div class="col-md-1">
				 <p class="text-center"><%= eventState %> </p>
			    </div>
			    <div class="col-md-2">
				 <p class="text-center"><%= dateTime %> </p>
			    </div>
			
			  <div class="col-md-1">
			  	
			  	<ul>  	
			  	<% for (String attendee : attendees) { %>
			  	  <li> <%= attendee %> </li>
			  <% } %>
			  	</ul>
			  </div>
			  <% if (request.getAttribute("loggedIn") != null && (Boolean) request.getAttribute("loggedIn")) 
			     { %>
			  <div class="col-md-1 col-md-offset-1">
			  	<form action="events/like" method="POST">
			  		<input type="submit" value="Like" class="btn btn-primary"/>
			  		<input type="hidden" name="eventId" value=" <%= eventId %> " />
			  	</form>
			  </div>
			  <% } %>
			</div>
			
			<% 
		}
	}
			%>
</div>
<% 
	//Set JavaScript files in footer
	String script = null;
%>

<%@include file="/WEB-INF/jsp/footer.jspf"  %>