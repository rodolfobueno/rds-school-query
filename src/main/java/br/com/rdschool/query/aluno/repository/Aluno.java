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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=true)
@Builder
@AllArgsConstructor
@NoArgsConstructor

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
	
}
