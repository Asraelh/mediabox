package mediabox.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import mediabox.model.*;

public interface IAnuncianteRepository extends CrudRepository<Anunciante, String> {

	@Query(value="SELECT * FROM ANUNCIANTE WHERE email =:email",nativeQuery=true)
	public Optional<Anunciante> findByEmail(@Param("email") String email);
	
	@Query(value="SELECT CheckUsername(:p_username,:p_password )",nativeQuery=true)
	public Boolean checkUsername(@Param("p_username") String username,@Param("p_password") String password);
}

