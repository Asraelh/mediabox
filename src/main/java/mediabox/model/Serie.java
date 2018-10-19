package mediabox.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Serie implements Serializable {
	
	@Id //En principio, esto no es autoincrementable
	private int idserie;
	private String categoria; //En principio, lo cojo como descripcion de categoria y no como id
	private String titulo;
	private int year;
	private String calificacion;
	private String descripcion;
	
	private String protagonista;
	private String director;
	private String imagen; //url de la imagen
	private String watch; //url de la pelicula en Netflix
	
	private int ncapitulos;
	private int ntemporadas;
	
	
	@Override
	public String toString() {
		return "Serie [idserie=" + idserie + ", categoria=" + categoria + ", titulo=" + titulo + ", year=" + year
				+ ", calificacion=" + calificacion + ", descripcion=" + descripcion + ", protagonista=" + protagonista
				+ ", director=" + director + ", imagen=" + imagen + ", watch=" + watch + ", ncapitulos=" + ncapitulos
				+ ", ntemporadas=" + ntemporadas + "]";
	}
	
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
	public int getNcapitulos() {
		return ncapitulos;
	}
	public void setNcapitulos(int ncapitulos) {
		this.ncapitulos = ncapitulos;
	}
	public int getNtemporadas() {
		return ntemporadas;
	}
	public void setNtemporadas(int ntemporadas) {
		this.ntemporadas = ntemporadas;
	}

	
	
	

}
