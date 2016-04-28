<%@include file="/WEB-INF/jsp/header.jspf" %>
<form action="create" method="POST">
<% 
	if ( request.getAttribute("createFailed") != null )
	{
%>
	<p style="color: red;">You must fill out all of the fields!</p>
<%  } %>

<% 
	if ( request.getAttribute("dateInPast") != null && (Boolean)request.getAttribute("dateInPast") == true )
	{
%>
	<p style="color: red;">Your date is in the past !</p>
<%  } %>

	<p>Event Name: </p><input type="text" name="eventName" />  
	<p>Address: </p><input type="text" name="eventStreetAddress" />
	<p>City: </p><input type="text" name="eventCity" /> 
	<p>State: </p><input type="text" name="eventState" />  
	<p><b>Event Time:</b></p><br />
	<p>Month: </p>
	<select name="month">
		<option value="1">January</option>
		<option value="2">February</option>
		<option value="3">March</option>
		<option value="4">April</option>
		<option value="5">May</option>
		<option value="6">June</option>
		<option value="7">July</option>
		<option value="8">August</option>
		<option value="9">September</option>
		<option value="10">October</option>
		<option value="11">November</option>
		<option value="12">December</option>
	</select><br />
	
	<p>Day (1-31): </p>
	<input type="text" name="day" />
	
	<p>Year: </p>
	<select name="year">
		<option value="2016">2016</option>
		<option value="2017">2017</option>
		<option value="2018">2018</option>
	</select><br />
	
	<p>Hour (0-23): </p>
	<input type="text" name="hour" />
	
	<p>Minute (0-59): </p>
	<input type="text" name="minute" />

	<input type="submit" />
</form>

<% 
	//Set JavaScript files in footer
	String script = null;
%>
<%@include file="/WEB-INF/jsp/footer.jspf"  %>