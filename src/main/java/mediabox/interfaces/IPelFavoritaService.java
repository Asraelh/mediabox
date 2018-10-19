package mediabox.interfaces;

import java.util.List;
import java.util.Optional;

import mediabox.model.PeliculaFavorita;

public interface IPelFavoritaService {
	
	public List<PeliculaFavorita> listarPeliculasFavporUsuario(String user);

}
