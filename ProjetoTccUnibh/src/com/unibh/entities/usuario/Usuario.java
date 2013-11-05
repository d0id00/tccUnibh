/**
 * 
 */
package com.unibh.entities.usuario;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.unibh.entities.AbstractEntity;
import com.unibh.entities.role.Role;
import com.unibh.entities.status.Status;

/**
 * @author Andre
 *
 */
@SuppressWarnings("serial")
@Entity
public class Usuario extends AbstractEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "idUsuario")
	private Integer id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(name = "login", unique = true, nullable = false)
	private String login;
	
	@Column(name = "senha", length = 8, nullable = false)
	private String senha;
	
	@Column(nullable = false)
	private Date dataReg;
	
	@ManyToOne
	@JoinColumn(name="idStatus")
	private Status status;
	
	@ManyToOne
	@JoinColumn(name="idRole")
	private Role role;
	
	public Usuario() {
		this.status = Status.ACTIVE;
		this.dataReg = new Date();
	}

	public Usuario(String nome, String login, String senha, Status status) {
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.dataReg = new Date();
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
	
	public Date getDataReg() {
		return dataReg;
	}

	public void setDataReg(Date dataReg) {
		this.dataReg = dataReg;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
