package mediabox.dao;

import org.springframework.data.repository.CrudRepository;

import mediabox.model.Usuario;



public interface IUsuarioRepository extends CrudRepository<Usuario, String> {

}
