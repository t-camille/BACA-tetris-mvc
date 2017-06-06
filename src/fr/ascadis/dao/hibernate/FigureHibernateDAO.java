package fr.ascadis.dao.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.ascadis.dao.IDAO;
import fr.ascadis.model.Figure;


@Repository("figureDAO")
@Transactional
public class FigureHibernateDAO implements IDAO<Figure, Integer>
{
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public List<Figure> findAll() {
		try {
			return this.entityManager.createQuery("from Figure", Figure.class).getResultList();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	@Override
	public Figure find(Integer id) {
		try {
			return this.entityManager.find(Figure.class, id);
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	@Override
	public Figure save(Figure figure) {
		try {
			return this.entityManager.merge(figure);
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return figure;
	}
	
	
	@Override
	public void delete(Figure figure) {
		try {
			this.entityManager.remove(this.entityManager.merge(figure));
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}