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
		
		@Override
		public List<Prueba> pruebaSelect() {
			Optional<List<Prueba>> usuarios=pruebaRepository.pruebaselect();
			if(usuarios.isPresent()) {
				return usuarios.get();
			}
			return null;
		}
		
	
		

}



