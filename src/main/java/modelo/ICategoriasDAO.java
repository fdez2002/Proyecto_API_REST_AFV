package modelo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriasDAO extends CrudRepository<CategoriasClass, Integer> {
}
