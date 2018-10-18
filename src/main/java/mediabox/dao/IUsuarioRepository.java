package mediabox.dao;

import org.springframework.data.repository.CrudRepository;

import mediabox.model.Usuario;



public interface IUsuarioRepository extends CrudRepository<Usuario, String> {

	boolean checkUser(String user, String password);

	void insertUser(String user, String password, String email, String alias, String nombre, String apellidos);

}
