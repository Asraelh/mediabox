package mediabox.dao;

import org.springframework.data.repository.CrudRepository;

import mediabox.model.PeliculaFavorita;



public interface IPelFavoritaRepository extends CrudRepository<PeliculaFavorita, String> {

}
