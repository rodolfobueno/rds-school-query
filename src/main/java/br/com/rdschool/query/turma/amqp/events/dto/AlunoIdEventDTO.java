package br.com.rdschool.query.turma.amqp.events.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AlunoIdEventDTO {

	private String id;
	
	private AlunoIdEventDTO(String id) {
		this.id = id;
	}

	public static AlunoIdEventDTO of(String id) {
		return new AlunoIdEventDTO(id);
	}
}
