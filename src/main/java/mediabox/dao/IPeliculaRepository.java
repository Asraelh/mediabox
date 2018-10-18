package mediabox.dao;

import org.springframework.data.repository.CrudRepository;

import mediabox.model.Pelicula;



public interface IPeliculaRepository extends CrudRepository<Pelicula, Integer> {

}
