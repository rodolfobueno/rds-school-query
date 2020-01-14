package br.com.rdschool.query.turma.amqp.events;

import java.util.Collection;

import br.com.rdschool.query.turma.amqp.events.dto.AlunoIdEventDTO;
import br.com.rdschool.query.turma.amqp.events.dto.DisciplinaIdEventDTO;
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
public final class TurmaCriadaEvent {
	
	public static final String NAME = "TurmaCriadaEvent";
	
	public static final String CONDITIONAL_EXPRESSION = "headers['type']=='" + NAME + "'"; 

	@NonNull
	private String turmaId;
	@NonNull
	private String descricao;
	@NonNull
	private Integer numeroVagas;
	@NonNull
	private Integer anoLetivo;
	@NonNull
	private Integer periodoLetivo;
	
	private Collection<AlunoIdEventDTO> alunosId;

	private Collection<DisciplinaIdEventDTO> disciplinasId;
	
}
