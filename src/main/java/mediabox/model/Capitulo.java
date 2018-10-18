package mediabox.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="netflix")
public class Capitulo implements Serializable {
	
	@Id //En principio, esto no es autoincrementable
	@Column(name="idcapitulo")
	private int idcapitulo;
	
	@Column(name="capitulos")
	private int capitulos;
	
	@Column(name="idtemporada")
	private int idtemporada;
	
	@Column(name="idserie")
	private int idserie;
	
	@Column(name="duracion")
	private int duracion;
	
	@Column(name="descripcion")
	private int descripcion;

	public int getIdcapitulo() {
		return idcapitulo;
	}

	public void setIdcapitulo(int idcapitulo) {
		this.idcapitulo = idcapitulo;
	}

	public int getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(int capitulos) {
		this.capitulos = capitulos;
	}

	public int getIdtemporada() {
		return idtemporada;
	}

	public void setIdtemporada(int idtemporada) {
		this.idtemporada = idtemporada;
	}

	public int getIdserie() {
		return idserie;
	}

	public void setIdserie(int idserie) {
		this.idserie = idserie;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public int getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(int descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
