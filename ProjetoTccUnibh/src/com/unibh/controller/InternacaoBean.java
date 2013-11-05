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

import com.unibh.entities.internacao.Internacao;
import com.unibh.entities.paciente.Paciente;
import com.unibh.service.InternacaoService;
import com.unibh.service.PacienteService;

/**
 * @author d0id00
 *
 */
@SuppressWarnings("serial")
@Controller
@Scope("view")
public class InternacaoBean extends AbstractManagerBean {
	
	@Autowired
	private InternacaoService internacaoService;
	
	@Autowired
	private PacienteService pacienteService;
	
	private Internacao selectedInternacao;
	
	private List<Internacao> internacoes;
	
	public InternacaoBean() {
		atualizaTela();
	}
	
	private void atualizaTela() {
		selectedInternacao = new Internacao();
		internacoes = new ArrayList<Internacao>();
	}

	@PostConstruct
	public void init() {
		selectedInternacao = new Internacao();
		internacoes = new ArrayList<Internacao>();
	}

	public Internacao getSelectedInternacao() {
		return selectedInternacao;
	}

	public void setSelectedInternacao(Internacao selectedInternacao) {
		this.selectedInternacao = selectedInternacao;
	}

	public List<Internacao> getInternacoes() {
		internacoes = internacaoService.findAll();
		return internacoes;
	}

	public void setInternacoes(List<Internacao> internacoes) {
		this.internacoes = internacoes;
	}

	 public List<Paciente> pacientes(String nome) {  
        List<Paciente> results = new ArrayList<Paciente>();
        results = pacienteService.getPacientes(nome);
        return results;  
    }  
	 
	public void salvar() {
		try {
			internacaoService.save(selectedInternacao);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Paciente cadastrado com sucesso!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		novoInternacao();
	}

	public void atualizar() {
		try {
			internacaoService.update(selectedInternacao);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Paciente atualizado com sucesso!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		novoInternacao();
	}
	
	public void remover() {
		try {
			internacaoService.delete(selectedInternacao);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Paciente removido com sucesso!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao remover o usuário!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		novoInternacao();
	}

	public void novoInternacao() {
		selectedInternacao = new Internacao();
	}
	
}
