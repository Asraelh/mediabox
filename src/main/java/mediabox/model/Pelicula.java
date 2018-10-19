package mediabox.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;

@Entity
@Table
public class Pelicula implements Serializable {
	
	@Id //En principio, esto no es autoincrementable
	private int idpelicula;
	private String categoria; 
	private String titulo;
	private int year;
	private String calificacion;
	private String duracion;
	private String descripcion;
	private String protagonista;
	private String director;
	private String imagen; //url de la imagen
	private String watch; //url de la pelicula en Netflix
	
	
	@Override
	public String toString() {
		return "Pelicula [idpelicula=" + idpelicula + ", categoria=" + categoria + ", titulo=" + titulo + ", year="
				+ year + ", calificacion=" + calificacion + ", duracion=" + duracion + ", descripcion=" + descripcion
				+ ", protagonista=" + protagonista + ", director=" + director + ", imagen=" + imagen + ", watch="
				+ watch + "]";
	}
	
	
	public String getDuracion() {
		return duracion;
	}


	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}



	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getWatch() {
		return watch;
	}

	public void setWatch(String watch) {
		this.watch = watch;
	}

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
