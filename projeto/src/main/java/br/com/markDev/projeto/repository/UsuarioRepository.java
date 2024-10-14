package br.com.markDev.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.markDev.projeto.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{

}
