package br.org.generation.redesocial.eleva.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.redesocial.eleva.model.Usuario;

@Repository
	public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

		public Optional<Usuario> findByUsuario(String usuario);

	}

