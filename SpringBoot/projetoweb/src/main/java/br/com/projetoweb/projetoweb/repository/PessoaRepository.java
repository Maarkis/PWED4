package br.com.projetoweb.projetoweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projetoweb.projetoweb.entity.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> { }
