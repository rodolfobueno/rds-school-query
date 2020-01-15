package br.com.rdschool.query.pessoa.model;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@MappedSuperclass
@AllArgsConstructor
public abstract class AbstractPessoa {
	
	@NotNull
	private String nome;
	
	@NotNull
	private String email;
	
	@NotNull
	private String cpf;
}
