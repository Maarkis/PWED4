package br.com.projetoweb.projetoweb.repository;

import br.com.projetoweb.projetoweb.entity.PerfilUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuario, Long> { }


