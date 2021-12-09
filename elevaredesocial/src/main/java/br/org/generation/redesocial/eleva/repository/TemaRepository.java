package br.org.generation.redesocial.eleva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.redesocial.eleva.model.Tema;

@Repository
public interface TemaRepository extends JpaRepository <Tema, Long> {
	
	public List<Tema>findAllByTituloTemaContainingIgnoreCase (String tituloTema);

	public List<Tema>findAllByTituloTemaContainsAndPalavraChaveContainsAllIgnoreCase (String tituloTema, String palavraChave);
}
