package br.com.zup.edu.autores.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 120)
	private String nome;

	@Column(nullable = false)
    private String email;

	@Column(nullable = false, length = 120)
    private String decricao;

	@Column(nullable = false)
    private String cpf;

	public Autor(String nome, String email, String decricao, String cpf) {
		this.nome = nome;
		this.email = email;
		this.decricao = decricao;
		this.cpf = cpf;
	}
	
	/**
	 * @deprecated construtor é de uso do hibernate
	 */
	@Deprecated
	public Autor() {
		
	}
	
	public Long getId() {
		return id;
	}
}
