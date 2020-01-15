package br.com.rdschool.query.aluno.repository.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rdschool.query.aluno.amqp.events.AlunoCriadoEvent;
import br.com.rdschool.query.aluno.repository.Aluno;
import br.com.rdschool.query.aluno.repository.AlunoRepository;
import br.com.rdschool.query.turma.repository.FormaIngresso;

@Service
@Transactional
public class AlunoService {

	@Autowired
	private AlunoRepository repository;
	
	public void handle(AlunoCriadoEvent event) {
		
		Aluno aluno = Aluno.builder()
				.id(event.getAlunoId())
				.matricula(event.getMatricula())
				.formaIngresso(FormaIngresso.valueOf(event.getFormaIngresso()))
				.nome(event.getNome())
				.cpf(event.getCpf())
				.email(event.getEmail()).build();

		repository.save(aluno);
	}
}