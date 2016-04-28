<%@include file="/WEB-INF/jsp/header.jspf" %>
<%@ page import="java.util.*, calendar.model.Event, java.util.Date" %>
<%
    @SuppressWarnings("unchecked")
    List<Event> createdEvents =
            (List<Event>)request.getAttribute("createdEvents");
	@SuppressWarnings("unchecked")
	List<Event> likedEvents = 
			(List<Event>)request.getAttribute("likedEvents");
	
	Boolean emptyCreatedEvents = (Boolean) request.getAttribute("emptyCreatedEvents");
	Boolean emptyLikedEvents = (Boolean) request.getAttribute("emptyLikedEvents");
%>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<h2 class="text-center"><b><%= request.getSession().getAttribute("username").toString() %>'s Events</b></h2>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6 col-md-offset-2">
			<h3 class="text-center"><b>Created Events</b></h3>
		</div>
	</div>	
	
	<% 
	if ( emptyCreatedEvents == false )
	{ %> 
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
	
	<% 	for (Event event : createdEvents)
		{ %>
		<div class="row">
			<div class="col-md-2">
				<p><%= event.getEventName() %></p>
			</div>
			<div class="col-md-2">
				<p><%= event.getEventStreetAddress() %></p>
			</div>
			<div class="col-md-2">
				<p><%= event.getEventCity() %></p>
			</div>
			<div class="col-md-2">
				<p><%= event.getEventState() %></p>
			</div>
			<div class="col-md-2">
				<p><%= event.getEventTime() %></p>
			</div>
		</div>
	 <% } 
    }
    else
    { %> 	
    	<div class="row">	
  			<div class="col-md-6">
  				<h4 class="text-center">No Created Events</h4>
  			</div>
  		</div>
<%  } %>
	<div class="row">
		<div class="col-md-6 col-md-offset-2">
			<h3 class="text-center"><b>Liked Events</b></h3>
		</div>
	</div>	
  <% if ( emptyLikedEvents == false )
	{ %> 
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
	<% 
		   for (Event event : likedEvents)
		   { %>
				<div class="row">
					<div class="col-md-2">
						<p><%= event.getEventName() %></p>
					</div>
					<div class="col-md-2">
						<p><%= event.getEventStreetAddress() %></p>
					</div>
					<div class="col-md-2">
						<p><%= event.getEventCity() %></p>
					</div>
					<div class="col-md-2">
						<p><%= event.getEventState() %></p>
					</div>
					<div class="col-md-2">
						<p><%= event.getEventTime() %></p>
					</div>
				</div>
	    <% }
	}
	else
	{ %> <div class="row">
   			<div class="col-md-6">
   				<h4 class="text-center">No Liked Events</h4>
   			</div>
   		</div>
  <% } %>

	
</div>
<% 
	//Set JavaScript files in footer
	String script = null;
%>
<%@include file="/WEB-INF/jsp/footer.jspf" %>