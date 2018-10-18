package mediabox.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


//En principio, la clase categoria ni siquiera es necesaria
@Entity
@Table(name="netflix")
public class Categoria implements Serializable {
	
	@Id
	@Column(name="idcategoria")
	private int idcategoria;
	
	@Column(name="descripcion")
	private String descripcion;

	public int getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
}
