package pe.company.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.company.model.CitaEntity;

@Repository
public interface CitaRepository extends CrudRepository<CitaEntity, Long> {

}
