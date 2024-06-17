package jpaswing.repository;

import jpaswing.entity.Noticia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiaRepository extends CrudRepository<Noticia, Long> {
    Noticia findById(int id);
}
