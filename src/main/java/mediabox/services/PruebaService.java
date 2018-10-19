package mediabox.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import mediabox.dao.*;
import mediabox.interfaces.*;
import mediabox.model.*;

@Service
public class PruebaService implements IPruebaService {
		
		@Autowired
		private IPruebaRepository pruebaRepository;
		@Autowired
		private IPeliculaRepository peliculaRepository;
		
		@Override
		public void pruebaSelect() {
			Optional<List<Pelicula>> usuarios=peliculaRepository.show5peliculas();
			
			
			if(usuarios.isPresent()) {
				List peliculas=usuarios.get();
				peliculas.forEach(p->System.out.println(p));
				
			}
		}
		
	
		

}



