<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<h1>Bienvenue ${ utilisateur.prenom } ${ utilisateur.nom } !</h1>

<form method="post" action="logout">
	<input type="hidden" name="action" value="logout" />
	
	<button class="btn waves-effect waves-light" type="submit">
		Se déconnecter <i class="material-icons right">lock</i>
	</button>
</form>