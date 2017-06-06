package fr.ascadis.dao.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.ascadis.dao.IUtilisateurDAO;
import fr.ascadis.model.Utilisateur;


@Repository("utilisateurDAO")
@Transactional
public class UtilisateurHibernateDAO implements IUtilisateurDAO
{
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public List<Utilisateur> findAll() {
		try {
			return this.entityManager.createQuery("from Utilisateur", Utilisateur.class).getResultList();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	@Override
	public Utilisateur find(Integer id) {
		try {
			return this.entityManager.find(Utilisateur.class, id);
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	@Override
	public Utilisateur save(Utilisateur utilisateur) {
		try {
			return this.entityManager.merge(utilisateur);
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return utilisateur;
	}
	
	
	@Override
	public void delete(Utilisateur utilisateur) {
		try {
			this.entityManager.remove(this.entityManager.merge(utilisateur));
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public Utilisateur auth(String username, String password) {
		try {
			return this.entityManager.createQuery("from Utilisateur u where u.username = :username AND u.password = :password", Utilisateur.class)
					.setParameter("username", username)
					.setParameter("password", password)
					.getSingleResult();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}