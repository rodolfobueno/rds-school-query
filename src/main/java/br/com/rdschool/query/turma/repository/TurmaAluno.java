package br.com.rdschool.query.turma.repository;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
public class TurmaAluno {

	@Id
	@GeneratedValue
	private UUID id;

	@NotNull
	private String alunoId;

	private TurmaAluno(String alunoId) {
		this.alunoId = alunoId;
	}

	public static TurmaAluno of(String alunoId) {
		return new TurmaAluno(alunoId);
	}
}
