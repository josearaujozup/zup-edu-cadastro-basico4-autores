package br.com.zup.edu.autores.controller;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import br.com.zup.edu.autores.model.Autor;

public class AutorDTO {
	
	@NotBlank
	@Size(max = 120)
	private String nome;

	@NotBlank
	@Email
    private String email;

	@NotBlank
	@Size(max = 2500)
    private String descricao;

	@NotBlank
	@CPF
    private String cpf;

	public AutorDTO(@NotBlank @Size(max = 120) String nome, @NotBlank @Email String email,
			@NotBlank @Size(max = 2500) String descricao, @NotBlank @CPF String cpf) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		this.cpf = cpf;
	}
	
	public AutorDTO() {
		
	}
	
	public Autor paraAutor() {
		return new Autor(nome, email, descricao, cpf);
	}
	
	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getCpf() {
		return cpf;
	}
	
}
