	<script src="https://code.jquery.com/jquery-2.2.0.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
	<c:if test="${script != null}">
		<c:set var="path">${script}</c:set>
		<script src="<c:url value='${path}'/>" ></script>
	</c:if>
</body>
</html>