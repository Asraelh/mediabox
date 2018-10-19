package mediabox.interfaces;

import java.util.List;
import java.util.Optional;

import mediabox.model.SerieFavorita;

public interface ISerieFavService {
	
	public Optional<List<SerieFavorita>> listarSeriesFavporUsuario(String user);

}
