package jpaswing.repository;

import jpaswing.entity.Fichaje;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FichajeRepository extends CrudRepository<Fichaje, Long> {
    Fichaje findById(int id);
}
