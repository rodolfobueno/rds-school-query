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
public class TurmaDisciplina {

	@Id
	@GeneratedValue
	private UUID id;

	@NotNull
	private String disciplinaId;

	private TurmaDisciplina(String disciplinaId) {
		this.disciplinaId = disciplinaId;
	}

	public static TurmaDisciplina of(String disciplinaId) {
		return new TurmaDisciplina(disciplinaId);
	}
}
