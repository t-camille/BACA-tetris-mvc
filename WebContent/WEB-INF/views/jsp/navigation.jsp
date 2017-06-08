<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav>
	<div class="nav-wrapper">
		<div class="container">
			<a href="#" class="brand-logo">Tetris - ${ pageTitle }</a>

			<c:if test="${ utilisateur != null }">
				<ul id="nav-mobile" class="right hide-on-med-and-down">
					<li><a href="${ pageContext.request.contextPath }/home">Accueil</a></li>

					<c:if test="${ utilisateur.type == 0 }">
						<li><a href="${ pageContext.request.contextPath }/tetriminos">Tetriminos</a></li>
					</c:if>

					<c:if test="${ utilisateur.type != 0 }">
						<li><a href="${ pageContext.request.contextPath }/partie">Parties</a></li>
					</c:if>

					<li><a href="?lang=fr">Français</a></li>
					<li><a href="?lang=en"></a>English</li>

				</ul>
			</c:if>
		</div>
	</div>
</nav>
