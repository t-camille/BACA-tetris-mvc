package fr.ascadis.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("0")
public class Administrateur extends Utilisateur
{
	private static final long serialVersionUID = 1L;
}