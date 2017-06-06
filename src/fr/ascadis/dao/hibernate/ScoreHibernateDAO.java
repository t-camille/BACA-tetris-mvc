package fr.ascadis.dao.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.ascadis.dao.IDAO;
import fr.ascadis.model.Score;


@Repository("scoreDAO")
@Transactional
public class ScoreHibernateDAO implements IDAO<Score, Integer>
{
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public List<Score> findAll() {
		try {
			return this.entityManager.createQuery("from Score", Score.class).getResultList();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	@Override
	public Score find(Integer id) {
		try {
			return this.entityManager.find(Score.class, id);
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	@Override
	public Score save(Score score) {
		try {
			return this.entityManager.merge(score);
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return score;
	}
	
	
	@Override
	public void delete(Score score) {
		try {
			this.entityManager.remove(this.entityManager.merge(score));
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}