<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		
		<!-- Materialize -->
		<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		<link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection" />
		<link type="text/css" rel="stylesheet" href="css/tetrimino.css" media="screen,projection" />
		<link type="text/css" rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/materialize.min.css" media="screen,projection" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
		<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.min.js" integrity="sha256-eGE6blurk5sHj+rmkfsGYeKyZx3M4bG+ZlFyA7Kns7E=" crossorigin="anonymous"></script>
		
		<title>${ pageTitle }</title>
	</head>
	
	<body>
		<tiles:insertAttribute name="navigation" />
		
		<div class="container">
			<tiles:insertAttribute name="body" />
		</div>
		
		<script type="text/javascript" src="js/materialize.min.js"></script>
		<script type="text/javascript" src="js/formesDrag&Drop.js"></script>
	</body>
</html>