package pe.company.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.company.model.CompraEntity;

@Repository
public interface CompraRepository extends CrudRepository<CompraEntity, Long> {

}
