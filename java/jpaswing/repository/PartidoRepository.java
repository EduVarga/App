package jpaswing.repository;

import jpaswing.entity.Partido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidoRepository extends CrudRepository<Partido, Long> {
    Partido findById(int id);
}
