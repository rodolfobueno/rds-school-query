package br.com.rdschool.query.aluno.amqp.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public final class AlunoCriadoEvent {

	public static final String NAME = "AlunoCriadoEvent";

	public static final String CONDITIONAL_EXPRESSION = "headers['type']=='" + NAME + "'";

	@NonNull
	private String alunoId;
	@NonNull
	private String nome;
	@NonNull
	private String email;
	@NonNull
	private String cpf;
	@NonNull
	private Integer matricula;
	@NonNull
	private String formaIngresso;

}
