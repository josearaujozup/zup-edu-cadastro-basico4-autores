package br.com.zup.edu.autores.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.edu.autores.model.Autor;
import br.com.zup.edu.autores.repository.AutorRepository;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
private final AutorRepository repository;
	
	public AutorController(AutorRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping
	ResponseEntity<Void> cadastrar(@RequestBody @Valid AutorDTO request, UriComponentsBuilder uriComponentsBuilder){
		Autor novoAutor = request.paraAutor();
		
		repository.save(novoAutor);
		
		URI location = uriComponentsBuilder.path("/autores/{id}").buildAndExpand(novoAutor.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remove(@PathVariable("id") Long idAutor){
		
		Autor autor = repository.findById(idAutor).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não existe cadastro de autor para o id informado"));
		
		repository.delete(autor);
		
		return ResponseEntity.noContent().build();
	}
	
}
