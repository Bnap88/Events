<%@include file="/WEB-INF/jsp/header.jsp" %>

<div class="container">
	<div class="row">
		<div class="col-lg-4 col-lg-offset-4 col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-12">
			<h2>Create Event</h2>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-4 col-lg-offset-4 col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-12">
			<form action="create" method="POST">
			
				<c:if test="${ not empty createFailed }">
					<p style="color: red;">You must fill out all of the fields!</p>
				</c:if>
				
				<c:if test="${not empty dateInPast && dateInPast == true}">
					<p style="color: red;">Your date is in the past !</p>
				</c:if>
				
				<div class="form-group">
					<label for="eventName">Event Name:</label>
					<input type="text" class="form-control" name="eventName" />  
				</div>

				<div class="form-group">
					<label for="eventAddress">Address:</label>
					<input type="text" class="form-control" name="eventStreetAddress" />
				</div>
				
				<div class="row">
					<div class="col-xs-9 col-sm-9 col-md-9 col-lg-9">
						<div class="form-group">
							<label for="eventCity">City:</label>
							<input type="text" class="form-control" name="eventCity" /> 
						</div>
					</div>
					<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
						<div class="form-group">
							<label for="eventState">State:</label>
							<select class="form-control" name="eventState">
									<option value="AL">AL</option>
									<option value="AK">AK</option>
									<option value="AZ">AZ</option>
									<option value="AR">AR</option>
									<option value="CA">CA</option>
									<option value="CO">CO</option>
									<option value="CT">CT</option>
									<option value="DE">DE</option>
									<option value="DC">DC</option>
									<option value="FL">FL</option>
									<option value="GA">GA</option>
									<option value="HI">HI</option>
									<option value="ID">ID</option>
									<option value="IL">IL</option>
									<option value="IN">IN</option>
									<option value="IA">IA</option>
									<option value="KS">KS</option>
									<option value="KY">KY</option>
									<option value="LA">LA</option>
									<option value="ME">ME</option>
									<option value="MD">MD</option>
									<option value="MA">MA</option>
									<option value="MI">MI</option>
									<option value="MN">MN</option>
									<option value="MS">MS</option>
									<option value="MO">MO</option>
									<option value="MT">MT</option>
									<option value="NE">NE</option>
									<option value="NV">NV</option>
									<option value="NH">NH</option>
									<option value="NJ">NJ</option>
									<option value="NM">NM</option>
									<option value="NY">NY</option>
									<option value="NC">NC</option>
									<option value="ND">ND</option>
									<option value="OH">OH</option>
									<option value="OK">OK</option>
									<option value="OR">OR</option>
									<option value="PA">PA</option>
									<option value="RI">RI</option>
									<option value="SC">SC</option>
									<option value="SD">SD</option>
									<option value="TN">TN</option>
									<option value="TX">TX</option>
									<option value="UT">UT</option>
									<option value="VT">VT</option>
									<option value="VA">VA</option>
									<option value="WA">WA</option>
									<option value="WV">WV</option>
									<option value="WI">WI</option>
									<option value="WY">WY</option>
							</select>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label for="eventTime">Event Date:</label>
					<input type="text" name="date" class="form-control date-picker" />
				</div>
				
				<div class="row">
					<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
						<div class="form-group">
							<label for="eventHour">Hour:</label>
							<select class="form-control" name="hour">
								<option value="0">12 am</option>
								<option value="1">1 am</option>
								<option value="2">2 am</option>
								<option value="3">3 am</option>
								<option value="4">4 am</option>
								<option value="5">5 am</option>
								<option value="6">6 am</option>
								<option value="7">7 am</option>
								<option value="8">8 am</option>
								<option value="9">9 am</option>
								<option value="10">10 am</option>
								<option value="11">11 am</option>
								<option value="12">12 pm</option>
								<option value="13">1 pm</option>
								<option value="14">2 pm</option>
								<option value="15">3 pm</option>
								<option value="16">4 pm</option>
								<option value="17">5 pm</option>
								<option value="18">6 pm</option>
								<option value="19">7 pm</option>
								<option value="20">8 pm</option>
								<option value="21">9 pm</option>
								<option value="22">10 pm</option>
								<option value="23">11 pm</option>
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
						<div class="form-group">
							<label for="eventMinute">Minute:</label>
							<select class="form-control" name="minute">
								<option value="0">:00</option>
								<option value="5">:05</option>
								<option value="10">:10</option>
								<option value="15">:15</option>
								<option value="20">:20</option>
								<option value="25">:25</option>
								<option value="30">:30</option>
								<option value="35">:35</option>
								<option value="40">:40</option>
								<option value="45">:45</option>
								<option value="50">:50</option>
								<option value="55">:55</option>
							</select>
						</div>
					</div>
				</div>
				<button type="submit" class="btn btn-primary">Create</button>
			</form>
		</div>
	</div>
</div>

<c:set var="script" value="/resources/js/createEvent.js"></c:set>

<%@include file="/WEB-INF/jsp/footer.jsp"  %>