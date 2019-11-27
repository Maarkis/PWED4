package br.com.projetoweb.projetoweb.repository;
import br.com.projetoweb.projetoweb.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
//    List<Usuario> findByLoginAndSenha(String login, String senha);
        List<Usuario> findByLoginAndSenha(String login, String senha);

}
