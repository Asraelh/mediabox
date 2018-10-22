package mediabox.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import mediabox.model.Pelicula;
import mediabox.model.Serie;

@Component
@Transactional
public interface ISerieRepository extends CrudRepository<Serie, Integer> {

	 @Query(nativeQuery = true,value = "CALL LISTALLSERIES")  // call store procedure 
	    List<Serie> listarTodas();

	 @Query(nativeQuery = true,value = "CALL SHOW5SERIES")  // call store procedure 
	    List<Serie> show5Series();
	 
	 @Query(nativeQuery = true,value = "CALL FINDSERIEBYID(:idserie)")  // call store procedure 
	    Serie findSerieById(@Param("idserie")int idserie);
	 
	 @Query(nativeQuery = true,value = "CALL listAllFavoriteSeries(:username)")  // call store procedure 
	 List<Serie> listAllFavoriteSeries(@Param("username")String username); 
	 
	 @Query(nativeQuery = true,value = "CALL insertFavorito(:username,:idpelicula)")  // call store procedure 
	 boolean insertarSerieFav(@Param("username")String username, @Param("idpelicula") int idpelicula); 
	 
	 @Query(nativeQuery = true,value = "CALL deleteFavorito(:username,:idpelicula)")  // call store procedure 
	 void borrarSerieFav(@Param("username")String username, @Param("idpelicula") int idpelicula); 
	 
	 @Query(nativeQuery = true,value = "SELECT checkFavorito(:username,:idpelicula)")  // call store procedure 
	 boolean checkSerieFav(@Param("username")String username, @Param("idpelicula") int idpelicula); 

}
