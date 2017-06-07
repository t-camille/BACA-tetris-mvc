/**
 * La mise en place de sortable permet le Drag&Drop des objet contenu dans row
 * Les objets sortables ont les mêmes propriétés que si ils étaient draggable
 */

$( function(){ 
	
  $(" .row").sortable({ // initialisation de Sortable
	update: function() {  // callback quand l'ordre de la liste est changé
		var order = $(' .row').sortable('serialize'); // récupération des données à envoyer
		$.post('changeFormesOrderServlet',order); // appel de servlet pour la maj de l'ordre en BDD
	}
  });
  
});