package fr.ascadis.dao.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.ascadis.dao.IDAO;
import fr.ascadis.model.Partie;


@Repository("partieDAO")
@Transactional
public class PartieHibernateDAO implements IDAO<Partie, Integer>
{
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public List<Partie> findAll() {
		try {
			return this.entityManager.createQuery("from Partie", Partie.class).getResultList();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	@Override
	public Partie find(Integer id) {
		try {
			return this.entityManager.find(Partie.class, id);
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	@Override
	public Partie save(Partie partie) {
		try {
			return this.entityManager.merge(partie);
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return partie;
	}
	
	
	@Override
	public void delete(Partie partie) {
		try {
			this.entityManager.remove(this.entityManager.merge(partie));
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}