package br.com.rdschool.query.aluno.amqp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import com.totvs.tjf.core.message.TOTVSMessage;
import com.totvs.tjf.messaging.WithoutTenant;

import br.com.rdschool.query.RDSExchange;
import br.com.rdschool.query.aluno.amqp.events.AlunoCriadoEvent;
import br.com.rdschool.query.aluno.repository.service.AlunoService;
import br.com.rdschool.query.turma.amqp.events.TurmaCriadaEvent;

@EnableBinding(RDSExchange.class)
public class AlunoSubscriber {

	@Autowired
	private AlunoService service;
	
	@WithoutTenant
	@StreamListener(target = RDSExchange.INPUT, condition = TurmaCriadaEvent.CONDITIONAL_EXPRESSION)
	public void turmaCriadaEvent(TOTVSMessage<AlunoCriadoEvent> event) {
		service.handle(event.getContent());
	}
}
