<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<form:form method="post" modelAttribute="inscription">
	<div class="input-field">
		<p>
			<form:radiobutton path="type" value="1" />
			<label for="type1"><spring:message code="account.subscribe.form.radio.type.joueur" /></label>
		</p>
		
		<p>
			<form:radiobutton path="type" value="2" />
			<label for="type2"><spring:message code="account.subscribe.form.radio.type.spectateur" /></label>
		</p>
	</div>
  	
  	
	<div class="input-field">
		<input id="nom" type="text" class="validate" name="nom" value="${ inscription.nom }" />
		<label for="nom"><spring:message code="account.subscribe.form.label.nom" /></label>
		<form:errors class="red-text" path="nom" />
	</div>
	
	<div class="input-field">
		<input id="prenom" type="text" class="validate" name="prenom" value="${ inscription.prenom }" />
		<label for="prenom"><spring:message code="account.subscribe.form.label.prenom" /></label>
		<form:errors class="red-text" path="prenom" />
	</div>
	
	<div class="input-field">
		<input id="username" type="text" class="validate" name="username" value="${ inscription.username }" />
		<label for="username"><spring:message code="account.subscribe.form.label.username" /></label>
		<form:errors class="red-text" path="username" />
	</div>
	
	<div class="input-field">
		<input id="password" type="password" class="validate" name="password" />
		<label for="password"><spring:message code="account.subscribe.form.label.password" /></label>
		<form:errors class="red-text" path="password" />
	</div>
	
	<div class="input-field">
		<input id="password-validation" type="password" class="validate" name="passwordCheck" />
		<label for="password-validation"><spring:message code="account.subscribe.form.label.passwordCheck" /></label>
	</div>
	
	
	<a class="btn red waves-effect waves-light" href="${ pageContext.request.contextPath }/account/login">
		<spring:message code="account.subscribe.form.cancel" /> <i class="material-icons right">fast_rewind</i>
	</a>
	
	<button class="btn waves-effect waves-light" type="submit">
		<spring:message code="account.subscribe.form.submit" /> <i class="material-icons right">send</i>
	</button>
</form:form>