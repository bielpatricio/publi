package br.com.matrix.publi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.matrix.publi.conta.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

}
