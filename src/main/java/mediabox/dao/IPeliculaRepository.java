package mediabox.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mediabox.model.Pelicula;
import mediabox.model.Prueba;



public interface IPeliculaRepository extends CrudRepository<Pelicula, Integer> {

	@Procedure(name = "SHOW5PELICULAS")
	public Optional<List<Pelicula>> show5peliculas();
}
