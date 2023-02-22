package modelo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductosDAO extends CrudRepository<ProductosClass, Integer> {
}
