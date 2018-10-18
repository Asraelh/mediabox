package mediabox.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import mediabox.model.*;

public interface IPruebaRepository extends CrudRepository<Prueba, Integer> {

	@Query(value="SELECT pruebaconexion()",nativeQuery=true)
	public String pruebaconexion();
	

}

