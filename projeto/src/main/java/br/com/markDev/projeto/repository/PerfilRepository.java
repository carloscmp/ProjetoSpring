package br.com.markDev.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.markDev.projeto.entity.PerfilEntity;

public interface PerfilRepository extends JpaRepository<PerfilEntity, Long>{

}