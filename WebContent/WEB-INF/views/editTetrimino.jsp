<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="row">
	<div class="col s3">
		<h5>Formulaire tetrimino</h5>
		<form method="post">
			<input type="hidden" name="tetrimino_id" value="${ tetrimino.id }" />
			
			<div class="input-field">
				<input id="tetrimino_nom" type="text" class="validate" name="tetrimino_nom" value="${ tetrimino.nom }" />
				<label for="tetrimino_nom">Nom</label>
			</div>
			
			<div class="input-field">
				<input id="tetrimino_couleur" type="text" class="validate" name="tetrimino_couleur" value="${ tetrimino.couleur }" />
				<label for="tetrimino_couleur">Couleur</label>
			</div>
			
			<button class="btn waves-effect waves-light" type="submit">
				Valider <i class="material-icons right">send</i>
			</button>
		</form>
	</div>
	
	<div class="col s9">
		<c:if test="${ tetrimino.id != null }">
			<div class="fixed-action-btn">
				<a href="${ pageContext.request.contextPath }/editFigure?tetrimino_id=${ tetrimino.id }" class="btn-floating btn-large red">
					<i class="large material-icons">add</i>
				</a>
			</div>
			
			
			<h5>Liste des figures</h5>
			
			<div class="row">
				<c:forEach items="${ tetrimino.figures }" var="figure">
					<div class="col s2">
						<a href="${ pageContext.request.contextPath }/deleteFigure?figure_id=${ figure.id }"><i class="material-icons">delete</i></a>
						
						<table class="figure">
							<c:forEach begin="0" end="3" step="1" var="i">
								<tr>
									<c:forEach begin="0" end="3" step="1" var="j">
										<c:set var="bloc" value="${ figure.findBloc(j, i) }" />
										
										<c:if test="${ bloc != null }">
											<td class="active" style="background-color: #${ tetrimino.couleur }">
												<a href="${ pageContext.request.contextPath }/deleteBloc?bloc_id=${ bloc.id }">&nbsp;</a>
											</td>
										</c:if>
										
										<c:if test="${ bloc == null }">
											<td>
												<a href="${ pageContext.request.contextPath }/editBloc?figure_id=${ figure.id }&position_x=${ j }&position_y=${ i }">&nbsp;</a>
											</td>
										</c:if>
									</c:forEach>
								</tr>
							</c:forEach>
						</table>
					</div>
				</c:forEach>
			</div>
		</c:if>
	</div>
</div>