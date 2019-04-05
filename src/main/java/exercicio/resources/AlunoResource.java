package exercicio.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import exercicio.resources.utils.URL;
import exercicio.domain.Aluno;
import exercicio.dtos.AlunoDto;
import exercicio.services.AlunoService;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {
	
	@Autowired
	private AlunoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Aluno> find(@PathVariable Integer id) {
		Aluno obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AlunoDto>> find(
			@RequestParam(value = "nome", defaultValue = "") String nome,
			@RequestParam(value = "disciplinas", defaultValue = "") String disciplinas) {

		String nomeDecoded = URL.decodeParam(nome);
		List<Integer> ids = URL.decodeIntList(disciplinas);
		List<Aluno> list = service.search(nomeDecoded, ids);
		List<AlunoDto> listDto = new ArrayList<AlunoDto>();
		for (Aluno p : list) {
			listDto.add(new AlunoDto(p));
		}
		return ResponseEntity.ok().body(listDto);

	}
}
