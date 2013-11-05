/**
 * 
 */
package com.unibh.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.unibh.entities.usuario.Usuario;
import com.unibh.service.RoleService;
import com.unibh.service.UsuarioService;

/**
 * @author d0id00
 *
 */
@SuppressWarnings("serial")
@Controller
@Scope("view")
public class UsuarioBean extends AbstractManagerBean {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private RoleService roleService;
	
	private Usuario selectedUsuario;
	
	private List<Usuario> usuarios;
	
	public UsuarioBean() {
		atualizaTela();
	}
	
	private void atualizaTela() {
		selectedUsuario = new Usuario();
		usuarios = new ArrayList<Usuario>();
	}

	@PostConstruct
	public void init() {
		usuarios = new ArrayList<Usuario>();
		selectedUsuario = new Usuario();
	}
	
	public Usuario getSelectedUsuario() {
		return selectedUsuario;
	}

	public void setSelectedUsuario(Usuario selectedUsuario) {
		this.selectedUsuario = selectedUsuario;
	}

	public List<Usuario> getUsuarios() {
		usuarios = usuarioService.findAll();
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void salvar() {
		try {
			this.selectedUsuario.setRole(roleService.getById(1));
			usuarioService.save(this.selectedUsuario);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário cadastrado com sucesso!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage().contains("Duplicate") ? "Já existe um usuário cadastrado com o login " + selectedUsuario.getLogin() : e.getMessage(), null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		novoUsuario();
	}

	public void atualizar() {
		try {
			usuarioService.update(this.selectedUsuario);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário atualizado com sucesso!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage().contains("Duplicate") ? "Já existe um usuário cadastrado com o login " + selectedUsuario.getLogin() : e.getMessage(), null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		novoUsuario();
	}
	
	public void remover() {
		try {
			usuarioService.delete(getSelectedUsuario());
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário removido com sucesso!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao remover o usuário!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		novoUsuario();
	}

	public void novoUsuario() {
		selectedUsuario = new Usuario();
	}
	
}
