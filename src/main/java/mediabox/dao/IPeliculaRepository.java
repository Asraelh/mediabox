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
import mediabox.model.Prueba;
import mediabox.model.Serie;


@Component
@Transactional
public interface IPeliculaRepository extends CrudRepository<Pelicula, Integer> {

	 @Query(nativeQuery = true,value = "CALL SHOW5PELICULAS")  // call store procedure 
	    List<Pelicula> show5peliculas();

	 @Query(nativeQuery = true,value = "CALL LISTALLPELICULAS")  // call store procedure 
	    List<Pelicula> listarTodas();
	
	
}
