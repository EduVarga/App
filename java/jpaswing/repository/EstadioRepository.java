package jpaswing.repository;

import jpaswing.entity.Estadio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadioRepository extends CrudRepository<Estadio, Long> {
    Estadio findById(int id);
}
