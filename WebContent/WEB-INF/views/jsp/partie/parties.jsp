<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>




<c:if test="${ utilisateur.type == 1 }">
	<div class="fixed-action-btn">
		<a href="addPartie" class="btn-floating btn-large red">
			<i class="large material-icons">add</i>
		</a>
	</div>
</c:if>


<div class="row">
	<ul class="collapsible" data-collapsible="accordion">
		<c:forEach items="${ parties }" var="partie">
			<li>
				<div class="collapsible-header">
					Partie #${ partie.id }
				</div>
				
				<div class="collapsible-body">
					<p>
						Joueur A : ${ partie.joueurA.prenom }
					</p>
					
					<p>
						Joueur B :
						
						<c:if test="${ partie.joueurB == null }">
							<c:choose>
								<c:when test="${ utilisateur.id != partie.joueurA.id && utilisateur.type == 1 }">
									<a href="joinPartie?partie_id=${ partie.id }">Rejoindre</a>
								</c:when>
								
								<c:otherwise>
									<i>En attente</i>
								</c:otherwise>
							</c:choose>
						</c:if>
						
						<c:if test="${ partie.joueurB != null }">
							${ partie.joueurB.prenom }
						</c:if>
					</p>
				</div>
			</li>
		</c:forEach>
	</ul>
</div>