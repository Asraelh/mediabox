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
	private IPruebaRepository pruebarepository;
	

	@Override
	public void pruebaconexion() {
		System.out.println(pruebarepository.pruebaconexion());
	}
	
}
