package mediabox.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mediabox.model.Usuario;


public interface IUsuarioRepository extends CrudRepository<Usuario, String> {
	

	@Query(value="CALL INSERTUSER(:username,:pass,:email,:alias,:nombre,:apellidos)",nativeQuery=true)
	public void insertUser(@Param("username") String user, @Param("pass") String password, @Param("email")String email, @Param("alias")String alias, @Param("nombre")String nombre, @Param("apellidos")String apellidos);
	
	@Query(value="SELECT CHECKUSER(:p_username,:p_password )",nativeQuery=true)
	public Boolean checkUser(@Param("p_username") String username,@Param("p_password") String password);

	

}
