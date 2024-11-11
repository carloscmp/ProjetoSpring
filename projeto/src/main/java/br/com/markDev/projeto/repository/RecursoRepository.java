package br.com.markDev.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.markDev.projeto.entity.RecursoEntity;

public interface RecursoRepository extends JpaRepository<RecursoEntity, Long>{

}
