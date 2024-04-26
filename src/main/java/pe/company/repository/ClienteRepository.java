package pe.company.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.company.model.ClienteEntity;



@Repository
public interface ClienteRepository extends CrudRepository<ClienteEntity, Long> {

}
