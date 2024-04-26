package pe.company.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.company.model.ProductoEntity;

@Repository
public interface ProductoRepository extends CrudRepository<ProductoEntity, Long>{

}
