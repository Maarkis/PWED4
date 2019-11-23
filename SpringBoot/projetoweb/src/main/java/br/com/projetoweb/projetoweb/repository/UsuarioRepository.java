package br.com.projetoweb.projetoweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projetoweb.projetoweb.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> { }
