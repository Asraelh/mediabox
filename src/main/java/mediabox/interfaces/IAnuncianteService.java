package mediabox.interfaces;

import java.util.List;

import mediabox.model.*;

public interface IAnuncianteService {

	Boolean existById(String username);

	void delete(String username);

	Anunciante findById(String username);

	Boolean existByEmail(String email);

	void save(Anunciante anunciante);

	Boolean login(String username, String passwordl);

	Boolean checkUsername(String username, String password);

	
	
}
