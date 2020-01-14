package br.com.rdschool.query.turma.amqp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import com.totvs.tjf.core.message.TOTVSMessage;
import com.totvs.tjf.messaging.WithoutTenant;

import br.com.rdschool.query.RDSExchange;
import br.com.rdschool.query.turma.amqp.events.TurmaCriadaEvent;
import br.com.rdschool.query.turma.repository.service.TurmaService;

@EnableBinding(RDSExchange.class)
public class TurmaSubscriber {

	@Autowired
	private TurmaService service;
	
	@WithoutTenant
	@StreamListener(target = RDSExchange.INPUT, condition = TurmaCriadaEvent.CONDITIONAL_EXPRESSION)
	public void turmaCriadaEvent(TOTVSMessage<TurmaCriadaEvent> event) {
		service.handle(event.getContent());
	}
}
