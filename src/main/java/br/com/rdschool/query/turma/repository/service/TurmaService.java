package br.com.rdschool.query.turma.repository.service;

import java.util.Collection;
import java.util.HashSet;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rdschool.query.turma.amqp.events.TurmaCriadaEvent;
import br.com.rdschool.query.turma.repository.Turma;
import br.com.rdschool.query.turma.repository.TurmaAluno;
import br.com.rdschool.query.turma.repository.TurmaDisciplina;
import br.com.rdschool.query.turma.repository.TurmaRepository;

@Service
@Transactional
public class TurmaService {

	@Autowired
	private TurmaRepository repository;
	
	public void handle(TurmaCriadaEvent event) {
		Collection<TurmaAluno> alunos = new HashSet<>();
		Collection<TurmaDisciplina> disciplinas = new HashSet<>();
		
		event.getAlunosId().forEach(aluno -> alunos.add(TurmaAluno.of(aluno.getId())));
		event.getDisciplinasId().forEach(disc -> disciplinas.add(TurmaDisciplina.of(disc.getId())));

		Turma turma = Turma.builder()
				.id(event.getTurmaId())
				.descricao(event.getDescricao())
				.anoLetivo(event.getAnoLetivo())
				.periodoLetivo(event.getPeriodoLetivo())
				.numeroVagas(event.getNumeroVagas())
				.alunos(alunos)
				.disciplinas(disciplinas)
				.build();

		repository.save(turma);
	}
}