package exercicio.dtos;

import java.io.Serializable;

import exercicio.domain.Disciplina;

public class DisciplinaDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Integer semestre;
	
	public DisciplinaDto(Disciplina d) {
		id = d.getId();
		nome = d.getNome();
		semestre = d.getSemestre();
	}
	
	public DisciplinaDto() {
		
	}
	
	public DisciplinaDto(Integer id, String nome, Integer semestre) {
		this.id = id;
		this.nome = nome;
		this.semestre = semestre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getSemestre() {
		return semestre;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DisciplinaDto other = (DisciplinaDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
