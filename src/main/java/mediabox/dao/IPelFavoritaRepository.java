package mediabox.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mediabox.model.PeliculaFavorita;



public interface IPelFavoritaRepository extends CrudRepository<PeliculaFavorita, String> {
	
	@Query(value="SELECT findFavoritoByUser(:p_username,'PELICULA')",nativeQuery=true)
	public Optional<List<PeliculaFavorita>> buscaPorUsuario(@Param("p_username") String username);
	
}
