package mediabox.dao;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import mediabox.model.*;
import mediabox.services.*;

@Component
@Transactional
public interface IPruebaRepository extends CrudRepository<Pelicula, Integer> {

	 @Query(nativeQuery = true,value = "CALL SHOW5PELICULAS")  // call store procedure 
	    List<Pelicula> show5peliculas();

	 @Query(nativeQuery = true,value = "CALL LISTALLPELICULAS")  // call store procedure 
	    List<Pelicula> listarpeliculas();
	
	 @Query(nativeQuery = true,value = "CALL FINDPELICULABYID(:idpelicula)")  // call store procedure 
	    Pelicula findFilmById(@Param("idpelicula")int idpelicula);

	 @Query(nativeQuery = true,value = "CALL SHOW5SERIES")  // call store procedure 
	    List<Serie> show5series();
	 
	 @Query(nativeQuery = true,value = "CALL LISTALLSERIES")  // call store procedure 
	    List<Serie> listarseries();


	 

}
