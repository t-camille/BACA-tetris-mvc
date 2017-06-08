<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<form:form method="POST" modelAttribute="user">

	<div class="input-field">
		<p>
			<input name="type" type="radio" id="type_joueur" value="1" checked />
			<label><spring:message
					code="account.subscribe.form.label.joueur" /></label>
		</p>

		<p>
			<input name="type" type="radio" id="type_spectateur" value="2" /> <label><spring:message
					code="account.subscribe.form.label.spectateur" /></label>
		</p>
	</div>

	<table>

		<tr>
			<td><label><spring:message
						code="account.subscribe.form.label.nom" /></label></td>
			<td><input name="nom" type="text" value="${ user.nom }" /></td>
			<td><form:errors path="nom" /></td>
		</tr>

		<tr>
			<td><label><spring:message
						code="account.subscribe.form.label.prenom" /></label></td>
			<td><input name="prenom" type="text" value="${ user.prenom }" /></td>
			<td><form:errors path="prenom" /></td>
		</tr>

		<tr>
			<td><label><spring:message
						code="account.subscribe.form.label.username" /></label></td>
			<td><input name="username" type="text"
				value="${ user.username }" /></td>
			<td><form:errors path="username" /></td>
		</tr>

		<tr>
			<td><label><spring:message
						code="account.subscribe.form.label.password" /></label></td>
			<td><input name="password" type="text" /></td>
			<td><form:errors path="password" /></td>
		</tr>
		<tr>
			<td><label><spring:message
						code="account.subscribe.form.label.passwordCheck" /></label></td>
			<td><input name="passwordCheck" type="password" /></td>
			<td><form:errors path="passwordCheck" /></td>
		</tr>



		<tr>
			<td colspan="2"><input type="submit"
				value="<spring:message code="account.subscribe.form.submit" />" /></td>
		</tr>
	</table>
</form:form>