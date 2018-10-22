package mediabox.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mediabox.dao.*;
import mediabox.interfaces.*;
import mediabox.model.*;

@Service
public class PruebaService implements IPruebaService {
		
		@Autowired
		private IPruebaRepository pruebaRepository;
		@Autowired
		private IUsuarioRepository usuariorepository;
		@Autowired
		private IPeliculaRepository pelicularepository;
		
		@Override
		public void pruebaSelect() {
			
			System.out.println("Servicio Prueba");
			
//			List<Pelicula> lista=pruebaRepository.show5peliculas();
//			List<Pelicula> lista=pruebaRepository.listarpeliculas();
//			Pelicula media=pruebaRepository.findFilmById(242142);
//			List<Serie> lista=pruebaRepository.show5series();
//			List<Serie> lista=pruebaRepository.listarseries();
			
			usuariorepository.updateUser("luis","1235","as");
//			System.out.println(check);
			
//			lista.forEach(p->System.out.println(p));

			
		}
		
	
		

}



