package exercicio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exercicio.domain.Disciplina;
import exercicio.repositories.DisciplinaRepository;

@Service
public class DisciplinaService {
	
	@Autowired
	private DisciplinaRepository rep;
	
	// BUSCAR POR ID
		public Disciplina find (Integer id) {
			Optional<Disciplina> obj = rep.findById(id);
			return obj.orElse(null);
		}
		
		// FAZER INSERÇÃO
		public Disciplina insert (Disciplina obj) {
			obj.setId(null);
			return rep.save(obj);
		}
		
		// ATUALIZAR DISCIPLINA SERVICE
		public Disciplina update (Disciplina obj) {
			find(obj.getId());
			return rep.save(obj);
		}
		
		//DELETAR
		public void delete (Integer id) {
			find(id);
			rep.deleteById(id);
		}
			
		//LISTAR TODAS
		public List<Disciplina> findAll(){
			return rep.findAll();
		}
}
