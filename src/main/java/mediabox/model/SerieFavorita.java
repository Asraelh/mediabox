package mediabox.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="netflix")
public class SerieFavorita implements Serializable {
	
	@Id
	@Column(name="idusuario")
	private String idusuario;
	
	@Column(name="idserie")
	private int idserie;

	public String getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public int getIdserie() {
		return idserie;
	}

	public void setIdserie(int idserie) {
		this.idserie = idserie;
	}
	
	

}
