package br.com.rdschool.query.aluno.repository;

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
import br.com.rdschool.query.turma.repository.FormaIngresso;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "aluno")
public class Aluno extends AbstractPessoa {

	@Id
	@Column
	private String id;

	@NotNull
	private Integer matricula;

	@Enumerated(EnumType.STRING)
	@NotNull
	private FormaIngresso formaIngresso;

	@Builder
	public Aluno(String id, String nome, String cpf, String email, @NotNull Integer matricula,
			@NotNull FormaIngresso formaIngresso) {
		super(id, nome, cpf);
		this.id = id;
		this.matricula = matricula;
		this.formaIngresso = formaIngresso;
	}

}
