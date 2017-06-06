package fr.ascadis.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class Spectateur extends Utilisateur
{
	private static final long serialVersionUID = 1L;
}