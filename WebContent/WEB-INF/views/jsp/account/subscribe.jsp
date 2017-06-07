<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form method="post" action="subscribe" modelAttribute="user">
	<table>
		<tr>
			<td><label for="type_joueur">Joueur</label></td>
			<td><input name="type" type="radio" value="1" /></td>
			<td><form:errors path="type_joueur" /></td>
		</tr>
		<tr>
			<td><label for="type_spectateur">Spectateur</label></td>
			<td><input name="type" type="radio" value="1" /></td>
			<td><form:errors path="type_spectateur" /></td>
		</tr>

		<tr>
			<td><label for="nom">Nom</label></td>
			<td><input name="nom" type="text" value="${ user.nom }" /></td>
			<td><form:errors path="nom" /></td>
		</tr>

		<tr>
			<td><label for="prenom">Prénom</label></td>
			<td><input name="prenom" type="text" value="${ user.prenom }" /></td>
			<td><form:errors path="prenom" /></td>
		</tr>

		<tr>
			<td><label for="username">Nom d'utilisateur</label></td>
			<td><input name="username" type="text"
				value="${ user.username }" /></td>
			<td><form:errors path="username" /></td>
		</tr>

		<tr>
			<td><label for="password">Mot de passe</label></td>
			<td><input name="password" type="text" /></td>
			<td><form:errors path="password" /></td>
		</tr>
		<tr>
			<td><label for="password">Vérification du mot de passe</label></td>
			<td><input name="password-validation" type="password" /></td>
			<td><form:errors path="password-validation" /></td>
		</tr>



		<tr>
			<td colspan="2"><input type="submit" value="S'inscrire" /></td>
		</tr>
	</table>
</form:form>