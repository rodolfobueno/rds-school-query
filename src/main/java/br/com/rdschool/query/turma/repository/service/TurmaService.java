package br.com.rdschool.query.turma.repository.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rdschool.query.turma.amqp.events.TurmaCriadaEvent;
import br.com.rdschool.query.turma.repository.TurmaModel;
import br.com.rdschool.query.turma.repository.TurmaRepository;

@Service
@Transactional
public class TurmaService {

	@Autowired
	private TurmaRepository repository;
	
	public void handle(TurmaCriadaEvent event) {
		TurmaModel turma = TurmaModel.builder()
				.id(event.getTurmaId())
				.descricao(event.getDescricao())
				.anoLetivo(event.getAnoLetivo())
				.periodoLetivo(event.getPeriodoLetivo())
				.numeroVagas(event.getNumeroVagas())
				.build();
		repository.save(turma);
	}
}