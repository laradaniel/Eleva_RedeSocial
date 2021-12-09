package br.org.generation.redesocial.eleva.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.redesocial.eleva.model.Tema;
import br.org.generation.redesocial.eleva.repository.TemaRepository;

@RestController
@CrossOrigin (origins = "*", allowedHeaders = "*")
@RequestMapping ("/tema")
public class temaController {

	
	@Autowired
	private TemaRepository temaRepository;
	
	@GetMapping
	public ResponseEntity<List<Tema>> findAllTema(){
		return ResponseEntity.ok(temaRepository.findAll());
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Tema> getById(@PathVariable long id){
		return temaRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	
	}
	@GetMapping("/tema/{tituloTema}")
	public ResponseEntity<List<Tema>> findAllByTituloTema (@PathVariable String tituloTema){
		return ResponseEntity.ok(temaRepository.findAllByTituloTemaContainingIgnoreCase(tituloTema));
				
	}
	@GetMapping("/tituloTema/{tituloTema}/palavraChave/{palavraChave}")
	public ResponseEntity<List<Tema>> GetByTituloTemaAndPalavraChave (@PathVariable String tituloTema, @PathVariable String palavraChave){
		return ResponseEntity.ok(temaRepository.findAllByTituloTemaContainsAndPalavraChaveContainsAllIgnoreCase(tituloTema, palavraChave));
	}
	
	@PostMapping
	public ResponseEntity<Tema> postTema (@Valid @RequestBody Tema tema){
		return ResponseEntity.status(HttpStatus.CREATED).body (temaRepository.save(tema));
	}
	
	@PutMapping
	public ResponseEntity<Tema> putTema (@Valid @RequestBody Tema tema){
		return temaRepository.findById(tema.getId())
		.map(resp -> {
			return ResponseEntity.ok().body(temaRepository.save(tema));
		})
		.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTema (@PathVariable Long id){
		return temaRepository.findById(id)
				.map(resp -> {
					temaRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
			
	
}
	
	









	
	
	
