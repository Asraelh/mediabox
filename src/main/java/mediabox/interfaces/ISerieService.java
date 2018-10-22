package mediabox.interfaces;

import java.util.List;

import mediabox.model.Pelicula;
import mediabox.model.Serie;

public interface ISerieService {
	
	public List<Serie> listarSeries();
	
	public List<Serie> listarCincoSeries();
	
	public Serie buscarSerieporId(int Idserie);
	
	public List<Serie> listarSeriesFavporUsuario(String user);
	
	//public boolean comprobarFavorito(int Idserie, String user);

}
