package mediabox.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="netflix")
public class Serie implements Serializable {
	
	@Id //En principio, esto no es autoincrementable
	@Column(name="idserie")
	private int idserie;
	
	@Column(name="categoria")
	private String categoria; //En principio, lo cojo como descripcion de categoria y no como id
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="year")
	private int year;
	
	@Column(name="calificacion")
	private String calificacion;
	
	@Column(name="ncapitulos")
	private int ncapitulos;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="ntemporadas")
	private int ntemporadas;

	public int getIdserie() {
		return idserie;
	}

	public void setIdserie(int idserie) {
		this.idserie = idserie;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}

	public int getNcapitulos() {
		return ncapitulos;
	}

	public void setNcapitulos(int ncapitulos) {
		this.ncapitulos = ncapitulos;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getNtemporadas() {
		return ntemporadas;
	}

	public void setNtemporadas(int ntemporadas) {
		this.ntemporadas = ntemporadas;
	}
	
	

}
