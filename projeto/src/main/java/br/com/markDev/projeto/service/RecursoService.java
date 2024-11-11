package br.com.markDev.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.markDev.projeto.dto.RecursoDTO;
import br.com.markDev.projeto.entity.RecursoEntity;
import br.com.markDev.projeto.repository.RecursoRepository;

@Service
public class RecursoService {

	@Autowired
	private RecursoRepository recursoRepository;

	public List<RecursoDTO> listarTodos() {
		List<RecursoEntity> recursos = recursoRepository.findAll();
		return recursos.stream().map(RecursoDTO::new).toList();
	}

	/* Create */
	public void inserir(RecursoDTO recurso) {
		RecursoEntity recursoEntity = new RecursoEntity(recurso);
		recursoRepository.save(recursoEntity);
	}

	/* Delete */
	public RecursoDTO alterar(RecursoDTO recurso) {
		RecursoEntity recursoEntity = new RecursoEntity(recurso);
		return new RecursoDTO(recursoRepository.save(recursoEntity));
	}

	/* Delete */
	public void excluir(Long id) {
		RecursoEntity recurso = recursoRepository.findById(id).get();
		recursoRepository.delete(recurso);
	}

	/* Buscar pelo Id */
	public RecursoDTO buscarPorId(Long id) {
		return new RecursoDTO(recursoRepository.findById(id).get());
	}
}