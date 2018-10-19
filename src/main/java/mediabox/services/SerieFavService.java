package mediabox.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mediabox.dao.ISerieFavRepository;
import mediabox.interfaces.ISerieFavService;
import mediabox.model.SerieFavorita;

@Service
public class SerieFavService implements ISerieFavService {

		@Autowired
		private ISerieFavRepository serieFavRepository;
		
		@Override
		public Optional<List<SerieFavorita>> listarSeriesFavporUsuario(String user) {
			// TODO Auto-generated method stub
			
			Optional<List<SerieFavorita>> serfav=serieFavRepository.buscaPorUsuario(user);
			
			if(serfav.isPresent()) {
				
				return serfav.get();
				
			}else {
				
				return null;
		}
		}
		

}