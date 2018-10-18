package mediabox.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mediabox.dao.IPeliculaRepository;
import mediabox.interfaces.IPeliculaService;
import mediabox.model.Pelicula;

public class PeliculaService implements IPeliculaService {

	@Autowired
	private IPeliculaRepository peliculasRepository;
	
	@Override
	public List<Pelicula> listarPeliculas() {
		// TODO Auto-generated method stub
		
		List<Pelicula> peliculas=new ArrayList();
		
		for(Pelicula p:peliculasRepository.findAll()) {
			
			peliculas.add(p);
			
		}
		
		return peliculas;
	}

}
