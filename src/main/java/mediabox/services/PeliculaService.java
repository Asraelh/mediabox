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
	
		List<Pelicula> o=peliculasRepository.show5peliculas();
		return o;
		
	}

	@Override
	public Pelicula buscarPeliculaporId(int Idpelicula) {
		// TODO Auto-generated method stub
		
		Pelicula pelicula=peliculasRepository.findFilmById(Idpelicula); 
		//Crear funcion findFilmById(Idpelicula) que devuelva una pelicula dado su Idpelicula
		
		return pelicula;
	}

	@Override
	public boolean comprobarFavorito(int Idpelicula, String user) {
		// TODO Auto-generated method stub
		
		boolean comprobacion=peliculasRepository.checkPeliculaFav(user, Idpelicula);
		
		return comprobacion;
	}

	@Override
	public List<Pelicula> listarPeliculasFavporUsuario(String user) {
		List<Pelicula> PeliculasFav=peliculasRepository.listAllFavoritePeliculas(user);
			
			return PeliculasFav;
		
	}

}
