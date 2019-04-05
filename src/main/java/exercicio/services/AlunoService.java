package exercicio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exercicio.domain.Aluno;
import exercicio.domain.Disciplina;
import exercicio.repositories.AlunoRepository;
import exercicio.repositories.DisciplinaRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository rep;
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	public Aluno find(Integer id) {
		Optional<Aluno> obj = rep.findById(id);
		return obj.orElse(null);
	}
	
	public List<Aluno> search(String nome, List<Integer> ids) {
		List<Disciplina> disciplinas = disciplinaRepository.findAllById(ids);
		return rep.findDistinctByNomeContainingAndDisciplinasIn(nome, disciplinas);
	}

}
