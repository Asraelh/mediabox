package mediabox.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mediabox.model.SerieFavorita;
import mediabox.model.Usuario;


public interface IUsuarioRepository extends CrudRepository<Usuario, String> {
	
	@Procedure(name = "INSERTUSER")
	public void insertUser(@Param("username") String user, @Param("pass") String password, @Param("email")String email, @Param("alias")String alias, @Param("nombre")String nombre, @Param("apellidos")String apellidos);
	
	@Query(value="SELECT CHECKLOGIN(:p_username,:p_password )",nativeQuery=true)
	public Boolean checkUser(@Param("p_username") String username,@Param("p_password") String password);

	@Query(value="SELECT CHECKEMAIL(:p_email)",nativeQuery=true)
	public Boolean checkEmail(@Param("p_email") String email);
	



}
