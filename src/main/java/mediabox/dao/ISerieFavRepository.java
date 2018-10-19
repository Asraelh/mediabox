package mediabox.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mediabox.model.SerieFavorita;



public interface ISerieFavRepository extends CrudRepository<SerieFavorita, String> {

	@Query(value="SELECT findFavoritoByUser(:p_username,'SERIE')",nativeQuery=true)
	public Optional<List<SerieFavorita>> buscaPorUsuario(@Param("p_username") String username);
}
