package fr.ascadis.dao;

import fr.ascadis.model.Utilisateur;


public interface IUtilisateurDAO extends IDAO<Utilisateur, Integer>
{
	public Utilisateur auth(String username, String password);
}