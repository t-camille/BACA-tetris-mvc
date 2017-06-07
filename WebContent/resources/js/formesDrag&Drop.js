/**
 * 
 */

$( function(){ 
	
  $("#.row").sortable({ // initialisation de Sortable sur #list-photos
	update: function() {  // callback quand l'ordre de la liste est changé
		var order = $('.row').sortable('serialize'); // récupération des données à envoyer
		$.post('changeFormesOrderServlet',order); // appel ajax au fichier ajax.php avec l'ordre des photos
	}
  });
  
});