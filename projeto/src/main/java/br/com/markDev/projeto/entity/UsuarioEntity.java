package br.com.markDev.projeto.entity;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

import br.com.markDev.projeto.dto.UsuarioDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity /*anotação para definir entidade*/
@Table(name = "MK_USUARIO")/*define o nome para o objeto no BD*/
public class UsuarioEntity {

	@Id /*define chave primaria*/
	@GeneratedValue(strategy = GenerationType.IDENTITY)/*chave para auto increment*/
	private Long id;
	
	@Column(nullable = false)/*anotação para dizer que o campo é de preenchimento obrigatório*/
	private String nome;
	
	@Column(nullable = false, unique = true/*define que não poderá haver dois logins iguais*/)
	private String login;
	
	@Column(nullable = false)
	private String senha;
	
	@Column(nullable = false)
	private String email;
	
	public Long getId() {
		return id;
	}
	
	public UsuarioEntity(UsuarioDTO usuario) {
		
		BeanUtils.copyProperties(usuario, this);
		
	}
	
	public UsuarioEntity() {
		
		
		
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioEntity other = (UsuarioEntity) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
