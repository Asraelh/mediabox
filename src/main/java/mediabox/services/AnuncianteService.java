package mediabox.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mediabox.dao.*;
import mediabox.interfaces.*;
import mediabox.model.*;

@Service
public class AnuncianteService implements IAnuncianteService {

	@Autowired
	private IAnuncianteRepository anuncianterepository;
	

	@Override
	public Anunciante findById(String username) {
		Optional<Anunciante>anunciante=anuncianterepository.findById(username);
		if(anunciante.isPresent()) {
			return anunciante.get();
		}
		return null;
	}
	
	
	@Override
	public void save(Anunciante anunciante) {
		anuncianterepository.save(anunciante);
	}
	
	@Override
	public void delete(String username) {
		anuncianterepository.deleteById(username);
	}
	
	@Override
	public Boolean existById(String username) {
		
		if(anuncianterepository.existsById(username)) {
			return true;
		}
		return false;
	}
	
	@Override
	public Boolean existByEmail(String email) {
		Optional<Anunciante>anunciante=anuncianterepository.findByEmail(email);
		if(anunciante.isPresent()) {
			return true;
		}
		return false;
	}
	
	@Override
	public Boolean login(String username,String password) {
		Optional<Anunciante>anunciante=anuncianterepository.findById(username);
		if(anunciante.isPresent()) {
			if(anunciante.get().getPassword().equals(password)) {
				return true;
			}
			return false;
		}
		return false;
	}
	
	
	@Override
	public Boolean checkUsername(String username,String password) {
		Boolean numero=anuncianterepository.checkUsername(username, password);
		if(numero==true) {
			return true;
		}
		return false;
	}
	

}
