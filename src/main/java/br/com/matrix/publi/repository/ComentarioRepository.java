package br.com.matrix.publi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.matrix.publi.model.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

}
