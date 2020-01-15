package br.com.rdschool.query.professor.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import br.com.rdschool.query.pessoa.model.AbstractPessoa;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "professor")
public class Professor extends AbstractPessoa {

	@Id
	@Column
	private String id;

	@Enumerated(EnumType.STRING)
	@NotNull
	private Titulacao titulacao;

	@Builder
	public Professor(String id, String nome, String cpf, String email, @NotNull Titulacao titulacao) {
		super(id, nome, cpf);
		this.id = id;
		this.titulacao = titulacao;
	}

}
