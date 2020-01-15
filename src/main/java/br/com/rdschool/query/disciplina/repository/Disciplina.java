package br.com.rdschool.query.disciplina.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "disciplina")
public class Disciplina {
	
	@Id
	@Column
	private String id;
	
	private String descricao;
	
	private String sigla;
	
	private Integer cargaHoraria;
	
	private String professorId;

}
