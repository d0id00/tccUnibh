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

import com.unibh.entities.paciente.Paciente;
import com.unibh.service.PacienteService;
import com.unibh.service.UsuarioService;

/**
 * @author d0id00
 *
 */
@SuppressWarnings("serial")
@Controller
@Scope("view")
public class PacienteBean extends AbstractManagerBean {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PacienteService pacienteService; 
	
	private Paciente selectedPaciente;
	
	private List<Paciente> pacientes;
	
	public PacienteBean() {
		atualizaTela();
	}
	
	private void atualizaTela() {
		selectedPaciente = new Paciente();
		pacientes = new ArrayList<Paciente>();
	}

	@PostConstruct
	public void init() {
		selectedPaciente = new Paciente();
		pacientes = new ArrayList<Paciente>();
	}

	public Paciente getSelectedPaciente() {
		return selectedPaciente;
	}

	public void setSelectedPaciente(Paciente selectedPaciente) {
		this.selectedPaciente = selectedPaciente;
	}

	public List<Paciente> getPacientes() {
		pacientes = pacienteService.findAll();
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public void salvar() {
		try {
			selectedPaciente.setUsuario(usuarioService.getByParam("login", FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario")));
			pacienteService.save(selectedPaciente);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Paciente cadastrado com sucesso!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		novoPaciente();
	}

	public void atualizar() {
		try {
			pacienteService.update(selectedPaciente);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Paciente atualizado com sucesso!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		novoPaciente();
	}
	
	public void remover() {
		try {
			pacienteService.delete(selectedPaciente);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Paciente removido com sucesso!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao remover o usuário!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		novoPaciente();
	}

	public void novoPaciente() {
		selectedPaciente= new Paciente();
	}
	
}
