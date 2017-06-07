<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<form method="post">
	<input type="hidden" name="tetrimino_id" value="${ tetrimino_id }" />
	<input type="hidden" name="bloc_id" value="${ bloc.id }" />
	
	<div class="input-field">
		<input id="bloc_poids" type="number" min="0" class="validate" name="bloc_poids" value="${ bloc.poids }" />
		<label for="bloc_poids">Poids</label>
	</div>
	
	<div class="input-field">
		<input id="bloc_position_x" type="number" min="0" class="validate" name="bloc_position_x" value="${ bloc.positionX }" />
		<label for="bloc_position_x">Position X</label>
	</div>
	
	<div class="input-field">
		<input id="bloc_position_y" type="number" min="0" class="validate" name="bloc_position_y" value="${ bloc.positionY }" />
		<label for="bloc_position_y">Position Y</label>
	</div>
	
	<button class="btn waves-effect waves-light" type="submit">
		Valider <i class="material-icons right">send</i>
	</button>
</form>