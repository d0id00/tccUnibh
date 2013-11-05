/**
 * 
 */
package com.unibh.entities.role;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.unibh.entities.AbstractEntity;
import com.unibh.entities.menu.RoleMenu;
import com.unibh.entities.status.Status;
import com.unibh.entities.usuario.Usuario;


/**
 * @author Andre
 *
 */
@SuppressWarnings("serial")
@Entity
public class Role extends AbstractEntity{
	
	@Id
	@GeneratedValue
	@Column(name = "idRole")
	private Integer id;
	
	@Column(length = 30, nullable = false, unique = true)
	private String nome;
	
	@Column(length = 50, nullable = false)
	private String descricao;
	
	@ManyToOne
	private Status status;
	
	@OneToMany
	private Set<Usuario> usuarios;
	
	@OneToMany
	private Set<RoleMenu> roleMenu;
	
	public Role() {
	}

	public Role(String nome, String descricao, Status status) {
		this.nome = nome;
		this.descricao = descricao;
		this.status = status;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Set<RoleMenu> getRoleMenu() {
		return roleMenu;
	}

	public void setRoleMenu(Set<RoleMenu> roleMenu) {
		this.roleMenu = roleMenu;
	}
	
}
