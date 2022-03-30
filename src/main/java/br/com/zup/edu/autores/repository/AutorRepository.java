package br.com.zup.edu.autores.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.edu.autores.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{

}
