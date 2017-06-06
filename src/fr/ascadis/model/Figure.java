package fr.ascadis.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="figure")
public class Figure implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="FIG_ID")
	private int id;
	
	@Column(name="FIG_ORDRE")
	private int ordre;
	
	@ManyToOne
	@JoinColumn(name="FIG_TETRIMINO_ID")
	private Tetrimino tetrimino;
	
	@OneToMany(mappedBy="figure")
	private List<Bloc> blocs;
	
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getOrdre() {
		return ordre;
	}
	
	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}
	
	public Tetrimino getTetrimino() {
		return tetrimino;
	}
	
	public void setTetrimino(Tetrimino tetrimino) {
		this.tetrimino = tetrimino;
	}
	
	
	
	public Bloc findBloc(int positionX, int positionY) {
		for (Bloc forBloc : this.blocs) {
			if ((forBloc.getPositionX() == positionX) && (forBloc.getPositionY() == positionY)) {
				return forBloc;
			}
		}
		
		return null;
	}
}