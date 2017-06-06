package fr.ascadis.dao.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.ascadis.dao.IDAO;
import fr.ascadis.model.Bloc;


@Repository("blocDAO")
@Transactional
public class BlocHibernateDAO implements IDAO<Bloc, Integer>
{
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public List<Bloc> findAll() {
		try {
			return this.entityManager.createQuery("from Bloc", Bloc.class).getResultList();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	@Override
	public Bloc find(Integer id) {
		try {
			return this.entityManager.find(Bloc.class, id);
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	@Override
	public Bloc save(Bloc bloc) {
		try {
			return this.entityManager.merge(bloc);
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return bloc;
	}
	
	
	@Override
	public void delete(Bloc bloc) {
		try {
			this.entityManager.remove(this.entityManager.merge(bloc));
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}