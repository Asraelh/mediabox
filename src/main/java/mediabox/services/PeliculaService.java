package mediabox.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mediabox.dao.IPeliculaRepository;
import mediabox.interfaces.IPeliculaService;
import mediabox.model.Pelicula;
import mediabox.model.PeliculaFavorita;

@Service
public class PeliculaService implements IPeliculaService {

	@Autowired
	private IPeliculaRepository peliculasRepository;
	
	@Override
	public List<Pelicula> listarPeliculas() {
		// TODO Auto-generated method stub
		System.err.println("Entra en PeliculaService");
		List<Pelicula> peliculas=new ArrayList();
		
		for(Pelicula p:peliculasRepository.listarTodas()) { //Incluir metodo listarTodas en el dao
			
			peliculas.add(p);
			
		}
		
		System.out.println("Ha salido del bucle");
		
		return peliculas;
	}

	@Override
	public List<Pelicula> listarCincoPeliculas() {
		// TODO Auto-generated method stub
	
		Optional<List<Pelicula>> o=peliculasRepository.show5peliculas();
		
		if(o.isPresent()) {
			
			return o.get();
			
		}else {
			
			return null;
	}
		
	}

}
