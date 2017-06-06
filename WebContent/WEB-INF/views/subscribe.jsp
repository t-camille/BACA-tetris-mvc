<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${ failure != null}">
	Impossible de s'inscrire. Veuillez recommencer.
</c:if>


<form method="post">
	<div class="input-field">
		<p>
			<input name="type" type="radio" id="type_joueur" value="1" />
			<label for="type_joueur">Joueur</label>
		</p>
		
		<p>
			<input name="type" type="radio" id="type_spectateur" value="2" />
			<label for="type_spectateur">Spectateur</label>
		</p>
	</div>
	
	<div class="input-field">
		<input id="nom" type="text" class="validate" name="nom" />
		<label for="nom">Votre nom</label>
	</div>
	
	<div class="input-field">
		<input id="prenom" type="text" class="validate" name="prenom" />
		<label for="prenom">Votre prénom</label>
	</div>
	
	<div class="input-field">
		<input id="username" type="text" class="validate" name="username" />
		<label for="username">Votre nom d'utilisateur</label>
	</div>
	
	<div class="input-field">
		<input id="password" type="password" class="validate" name="password" />
		<label for="password">Votre mot de passe</label>
	</div>
	
	<div class="input-field">
		<input id="password-validation" type="password" class="validate" name="password-validation" />
		<label for="password-validation">Vérification de votre mot de passe</label>
	</div>
	
	
	<button class="btn waves-effect waves-light" type="submit">
		OK <i class="material-icons right">send</i>
	</button>
</form>