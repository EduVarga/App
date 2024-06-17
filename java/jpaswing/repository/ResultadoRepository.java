package jpaswing.repository;

import jpaswing.entity.Resultado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadoRepository extends CrudRepository<Resultado, Long> {
    Resultado findById(int id);
}
