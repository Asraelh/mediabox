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
		
		@Override
		public void pruebaSelect() {
			
			System.out.println("Servicio Prueba");
			
			List<Pelicula> peliculas=pruebaRepository.show5peliculas();
			
//			
//			if(usuarios.isPresent()) {
//				List peliculas=usuarios.get();
				peliculas.forEach(p->System.out.println(p));
				
//			}
		}
		
	
		

}



