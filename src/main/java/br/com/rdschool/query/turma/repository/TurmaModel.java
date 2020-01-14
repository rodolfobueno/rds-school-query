package br.com.rdschool.query.turma.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "turma")
public class TurmaModel {
	
	@Id
	@Column
	private String id;
	
	@NotNull
	private String descricao;
	
	@NotNull
	private Integer anoLetivo;
	
	@NotNull
	private Integer periodoLetivo;
	
	@NotNull
	private Integer numeroVagas;
	
}
