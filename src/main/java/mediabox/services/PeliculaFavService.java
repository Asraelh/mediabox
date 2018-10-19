package mediabox.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mediabox.dao.IPelFavoritaRepository;
import mediabox.interfaces.IPelFavoritaService;
import mediabox.model.PeliculaFavorita;

@Service
public class PeliculaFavService implements IPelFavoritaService {
	
	@Autowired
	private IPelFavoritaRepository pelFavRepository;
	
	@Override
	public Optional<List<PeliculaFavorita>> listarPeliculasFavporUsuario(String user) {
		// TODO Auto-generated method stub
		
		Optional<List<PeliculaFavorita>> o=pelFavRepository.buscaPorUsuario(user);
		
		if(o.isPresent()) {
			
			return o.get();
			
		}else {
			
			return null;
	}
	}
}
