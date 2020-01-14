package br.com.rdschool.query.turma.amqp.events.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DisciplinaIdEventDTO {

	private String id;
	
	private DisciplinaIdEventDTO(String id) {
		this.id = id;
	}

	public static DisciplinaIdEventDTO of(String id) {
		return new DisciplinaIdEventDTO(id);
	}
}
