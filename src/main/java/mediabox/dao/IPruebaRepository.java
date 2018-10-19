package mediabox.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mediabox.model.*;
import mediabox.services.*;

public interface IPruebaRepository extends CrudRepository<Prueba, Integer> {

	
	@Procedure(name = "pruebaselect")
	public Optional<List<Prueba>> pruebaselect();

}
