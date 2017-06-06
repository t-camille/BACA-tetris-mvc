package fr.ascadis.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Joueur extends Utilisateur
{
	private static final long serialVersionUID = 1L;
}