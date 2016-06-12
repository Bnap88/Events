<c:set var="loggedIn" value="false"/>
<c:if test="${sessionScope.username != null}">
	<c:set var="loggedIn" value="true"/>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		
		<title>Social Calendar</title>
		
		<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" />
		<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/styles.css" />" />
	</head>
<body>
<div>
    <nav role="navigation" class="navbar navbar-inverse">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="<c:url value='/events' />" class="navbar-brand">Social Calendar</a>
        </div>
        <!-- Collection of nav links and other content for toggling -->
        <div id="navbarCollapse" class="collapse navbar-collapse">
	        <c:if test="${loggedIn == true}">
	            <ul class="nav navbar-nav">
	                <li><a href="<c:url value='/events/accountevents'></c:url>">My Account</a></li>
	                <li><a href="<c:url value='/events/create'></c:url>">Create Event</a></li>
	            </ul> 
			</c:if>
            <ul class="nav navbar-nav navbar-right">
            <c:choose>
            	<c:when test="${loggedIn == true}">
                	<li><a href="<c:url value='/account/logout'></c:url>">Logout</a></li>
                </c:when>
                <c:otherwise>
                	<li><a href="<c:url value='/account/login'></c:url>">Login</a></li>
                </c:otherwise>
            </c:choose>
            </ul>
        </div>
    </nav>
</div>