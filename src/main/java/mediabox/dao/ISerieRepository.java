package mediabox.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import mediabox.model.Serie;

@Component
@Transactional
public interface ISerieRepository extends CrudRepository<Serie, Integer> {

	 @Query(nativeQuery = true,value = "CALL LISTALLSERIES")  // call store procedure 
	    List<Serie> listarTodas();

	 @Query(nativeQuery = true,value = "CALL SHOW5SERIES")  // call store procedure 
	    List<Serie> show5Series();

}
