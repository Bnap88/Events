	<script src="https://code.jquery.com/jquery-2.2.0.js"></script>
	<script src="https://code.jquery.com/ui/1.12.0-rc.1/jquery-ui.js" integrity="sha256-IY2gCpIs4xnQTJzCIPlL3uUgSOwVQYD9M8t208V+7KA=" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
	<c:if test="${script != null}">
		<c:set var="path">${script}</c:set>
		<script src="<c:url value='${path}'/>" ></script>
	</c:if>
</body>
</html>