<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form method="POST" modelAttribute="user">

<div class="input-field">
        <p>
            <input name="type" type="radio" id="type_joueur" value="1" checked />
            <label for="type_joueur">Joueur</label>
        </p>
        
        <p>
            <input name="type" type="radio" id="type_spectateur" value="2" />
            <label for="type_spectateur">Spectateur</label>
        </p>
    </div>
    
	<table>
		
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
			<td><input name="passwordCheck" type="password" /></td>
			<td><form:errors path="passwordCheck" /></td>
		</tr>



		<tr>
			<td colspan="2"><input type="submit" value="S'inscrire" /></td>
		</tr>
	</table>
</form:form>