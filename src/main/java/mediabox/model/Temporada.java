package mediabox.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="netflix")
public class Temporada implements Serializable {
	
	@Id //En principio, esto no es autoincrementable
	@Column(name="idtemporada")
	private int idtemporada;
	
	@Column(name="capitulos")
	private int capitulos;
	
	@Column(name="idserie")
	private int idserie;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="trailer")
	private String trailer;

	public int getIdtemporada() {
		return idtemporada;
	}

	public void setIdtemporada(int idtemporada) {
		this.idtemporada = idtemporada;
	}

	public int getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(int capitulos) {
		this.capitulos = capitulos;
	}

	public int getIdserie() {
		return idserie;
	}

	public void setIdserie(int idserie) {
		this.idserie = idserie;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}
	
	

}
