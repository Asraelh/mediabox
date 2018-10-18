package mediabox.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="netflix")
public class Pelicula implements Serializable {
	
	@Id //En principio, esto no es autoincrementable
	@Column(name="idpelicula")
	private int idpelicula;
	
	@Column(name="categoria")
	private String categoria; //En principio, lo cojo como descripcion de categoria y no como id
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="year")
	private int year;
	
	@Column(name="calificacion")
	private String calificacion;
	
	@Column(name="duracion")
	private int duracion;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="protagonista")
	private String protagonista;
	
	@Column(name="director")
	private String director;
	
	@Column(name="trailer")
	private String trailer; //url del trailer


	public int getIdpelicula() {
		return idpelicula;
	}

	public void setIdpelicula(int idpelicula) {
		this.idpelicula = idpelicula;
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

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getProtagonista() {
		return protagonista;
	}

	public void setProtagonista(String protagonista) {
		this.protagonista = protagonista;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	

}
