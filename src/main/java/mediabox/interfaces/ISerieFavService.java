package mediabox.interfaces;

import java.util.List;
import java.util.Optional;

import mediabox.model.SerieFavorita;

public interface ISerieFavService {
	
	public List<SerieFavorita> listarSeriesFavporUsuario(String user);

}
