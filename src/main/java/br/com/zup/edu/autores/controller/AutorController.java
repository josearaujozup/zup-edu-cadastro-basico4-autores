package br.com.zup.edu.autores.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
		
		URI location = uriComponentsBuilder.path("/autores/{id}").buildAndExpand(novoAutor.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
}
