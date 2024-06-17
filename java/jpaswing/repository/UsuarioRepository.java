package jpaswing.repository;

import jpaswing.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    Usuario findByUsuarioAndContrasena(String usuario, String contrasena);
    Usuario findByUsuario(String usuario);
}
