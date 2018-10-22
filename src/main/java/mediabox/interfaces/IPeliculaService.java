package mediabox.interfaces;

import java.util.List;

import mediabox.model.Pelicula;

public interface IPeliculaService {
	
	public List<Pelicula> listarPeliculas();
	
	public List<Pelicula> listarCincoPeliculas();
	
	public Pelicula buscarPeliculaporId(int Idpelicula);
	
	//public boolean comprobarFavorito(int Idpelicula, String user);
	
	public List<Pelicula> listarPeliculasFavporUsuario(String user);

}
