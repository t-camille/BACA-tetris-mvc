<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<form method="post" action="login">
	<input type="hidden" name="action" value="login" />
	
	<div class="input-field">
		<i class="material-icons prefix">account_circle</i>
		<input id="name" type="text" class="validate" name="username" />
		<label for="name">Votre nom</label>
	</div>
	
	<div class="input-field">
		<i class="material-icons prefix">vpn_key</i>
		<input id="password" type="password" class="validate" name="password" />
		<label for="password">Votre mot de passe</label>
	</div>
	
	<button class="btn waves-effect waves-light" type="submit">
		OK <i class="material-icons right">send</i>
	</button>
	
	<a href="subscribe" class="btn waves-effect waves-light" type="submit">
		S'inscrire
	</a>
</form>