package mediabox.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mediabox.model.*;
import mediabox.services.*;

public interface IPruebaRepository extends CrudRepository<Usuario, Integer> {

	
	@Query(value="CALL pruebaselect()",nativeQuery=true)
	public Optional<List<Usuario>> pruebaselect();

}
