package exercicio.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exercicio.domain.Aluno;
import exercicio.domain.Disciplina;
import exercicio.repositories.AlunoRepository;
import exercicio.repositories.DisciplinaRepository;

@Service
public class DbService {
	
	@Autowired
	private AlunoRepository aluRep;
	
	@Autowired
	private DisciplinaRepository disRep;
	
	public void inicializaBancoDeDados() throws ParseException {
		Disciplina d1 = new Disciplina(null, "Prog Web", 5);
		Disciplina d2 = new Disciplina(null, "POO", 3);
		Disciplina d3 = new Disciplina(null, "TAP", 4);
		
		Aluno a1 = new Aluno(null, "Gustavo", "email");
		Aluno a2 = new Aluno(null, "Lucas", "emailLucas");
		Aluno a3 = new Aluno(null, "Piong", "emailPiong");
		a1.getDisciplinas().addAll(Arrays.asList(d1));
		a2.getDisciplinas().addAll(Arrays.asList(d2,d3));
		a3.getDisciplinas().addAll(Arrays.asList(d1,d2,d3));
		d1.getAlunos().addAll(Arrays.asList(a1,a3));
		d2.getAlunos().addAll(Arrays.asList(a1,a2,a3));
		d3.getAlunos().addAll(Arrays.asList(a2));
		
		disRep.saveAll(Arrays.asList(d1, d2, d3));
		aluRep.saveAll(Arrays.asList(a1,a2,a3));
		
	}
}
