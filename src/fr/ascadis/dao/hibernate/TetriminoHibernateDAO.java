package fr.ascadis.dao.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.ascadis.dao.IDAO;
import fr.ascadis.model.Tetrimino;

@Repository("tetriminoDAO")
@Transactional
public class TetriminoHibernateDAO implements IDAO<Tetrimino, String>
{
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public List<Tetrimino> findAll() {
		try {
			return this.entityManager.createQuery("from Tetrimino", Tetrimino.class).getResultList();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	@Override
	public Tetrimino find(String id) {
		try {
			return this.entityManager.find(Tetrimino.class, id);
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	@Override
	public Tetrimino save(Tetrimino tetrimino) {
		try {
			return this.entityManager.merge(tetrimino);
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return tetrimino;
	}
	
	
	@Override
	public void delete(Tetrimino tetrimino) {
		try {
			this.entityManager.remove(this.entityManager.merge(tetrimino));
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}