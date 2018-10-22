package mediabox.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import mediabox.model.Pelicula;
import mediabox.model.SerieFavorita;
import mediabox.model.Usuario;

@Component
@Transactional
public interface IUsuarioRepository extends CrudRepository<Usuario, String> {
	
	@Procedure(name = "INSERTUSER")
	public void insertUser(@Param("idusuario") String idusuario, @Param("password") String password, @Param("email")String email, @Param("alias")String alias, @Param("nombre")String nombre, @Param("apellidos")String apellidos);
	
	@Query(value="SELECT CHECKLOGIN(:p_username,:p_password )",nativeQuery=true)
	public Boolean checkLogin(@Param("p_username") String username,@Param("p_password") String password);
	
	@Query(value="SELECT CHECKUSER(:p_username)",nativeQuery=true)
	public Boolean checkUser(@Param("p_username") String username);

	@Query(value="SELECT CHECKEMAIL(:p_email)",nativeQuery=true)
	public Boolean checkEmail(@Param("p_email") String email);
	
	 @Query(nativeQuery = true,value = "CALL SELECTUSER(:idusuario)")  // call store procedure 
	    Usuario selectUser(@Param("idusuario") String idusuario);

	 @Procedure(name = "UPDATEUSER")
		public void updateUser(@Param("username") String user, @Param("pass") String password, @Param("email")String email);


}
