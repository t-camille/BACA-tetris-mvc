<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<!-- Langues -->
<ul id="langues" class="dropdown-content">
  <li><a href="?lang=fr">Français</a></li>
  <li><a href="?lang=en">English</a></li>
</ul>


<nav>
	<div class="nav-wrapper">
		<div class="container">
			<a href="#" class="brand-logo">Tetris - <spring:message code="${ titleCode }" /></a>
			
			
			<ul id="nav-mobile" class="right hide-on-med-and-down">
				<c:if test="${ utilisateur != null }">
					<li><a href="${ pageContext.request.contextPath }/home"><spring:message code="menu.home" /></a></li>
					
					<c:if test="${ utilisateur.type == 0 }">
						<li><a href="${ pageContext.request.contextPath }/tetrimino"><spring:message code="menu.tetriminos" /></a></li>
					</c:if>
					
					<c:if test="${ utilisateur.type != 0 }">
						<li><a href="${ pageContext.request.contextPath }/partie">Parties</a></li>
					</c:if>
				</c:if>
				
				<!-- Langues -->
   				<li><a class="dropdown-button" href="#!" data-activates="langues"><spring:message code="menu.lang" /><i class="material-icons right">arrow_drop_down</i></a></li>
			</ul>
			
		</div>
	</div>
</nav>