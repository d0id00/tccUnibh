/**
 * 
 */
package com.unibh.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.unibh.entities.acompanhamento.Acompanhamento;
import com.unibh.entities.internacao.Internacao;
import com.unibh.entities.status.Status;
import com.unibh.service.AcompanhamentoService;
import com.unibh.service.InternacaoService;
import com.unibh.service.StatusService;

/**
 * @author d0id00
 *
 */
@SuppressWarnings("serial")
@Controller
@Scope("view")
public class AcompanhamentoBean extends AbstractManagerBean {
	
	@Autowired
	private AcompanhamentoService acompanhamentoService;
	
	@Autowired
	private InternacaoService internacaoService;
	
	@Autowired
	private StatusService statusService;
	
	private Acompanhamento selectedAcompanhamento;
	
	private List<Acompanhamento> acompanhamentos;
	
	public AcompanhamentoBean() {
		atualizaTela();
	}
	
	private void atualizaTela() {
		selectedAcompanhamento = new Acompanhamento();
		acompanhamentos = new ArrayList<Acompanhamento>();
	}

	@PostConstruct
	public void init() {
		acompanhamentos = new ArrayList<Acompanhamento>();
		selectedAcompanhamento = new Acompanhamento();
	}
	
	public Acompanhamento getSelectedAcompanhamento() {
		return selectedAcompanhamento;
	}

	public void setSelectedAcompanhamento(Acompanhamento selectedAcompanhamento) {
		this.selectedAcompanhamento = selectedAcompanhamento;
	}

	public List<Acompanhamento> getAcompanhamentos() {
		acompanhamentos = acompanhamentoService.findAll();
		return acompanhamentos;
	}

	public void setAcompanhamentos(List<Acompanhamento> acompanhamentos) {
		this.acompanhamentos = acompanhamentos;
	}
	
	public List<Status> getStatusForOther() {
		return statusService.getListByParam("tipo", Status.TYPE_STATUS_OTHER);
	}

	public Set<String> getViaAdministracao() {
		HashSet<String> via = new HashSet<String>();
		via.add("Sonda Nasoenteral");
		via.add("Gastronomia");
		via.add("Jejunnostomia");
		via.add("Acesso Venoso");
		return via;
	}
	
	public Set<String> getDesfecho() {
		HashSet<String> desfecho = new HashSet<String>();
		desfecho.add("Alta Hospitalar");
		desfecho.add("Alta por Piora Clínica");
		desfecho.add("Alta com NE Domiciliar");
		desfecho.add("Óbito");
		return desfecho;
	}
	
	public List<Internacao> internacoes(String nome) {  
        List<Internacao> results = new ArrayList<Internacao>();
        results = internacaoService.getInternacoesAbertas(nome);
        return results;  
    }  
	
	public void salvar() {
		try {
			acompanhamentoService.save(selectedAcompanhamento);
			Internacao inter = internacaoService.getById(selectedAcompanhamento.getInternacao().getId());
			inter.setAcompanhamento(selectedAcompanhamento);
			acompanhamentoService.save(selectedAcompanhamento);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Acompanhamento Paciente cadastrado com sucesso!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		novoAcompanhamento();
	}

	public void atualizar() {
		try {
			acompanhamentoService.update(this.selectedAcompanhamento);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Acompanhamento Paciente atualizado com sucesso!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		novoAcompanhamento();
	}
	
	public void remover() {
		try {
			acompanhamentoService.delete(getSelectedAcompanhamento());
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Acompanhamento Paciente removido com sucesso!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao remover o Acompanhamento do Paciente!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		novoAcompanhamento();
	}

	public void novoAcompanhamento() {
		selectedAcompanhamento = new Acompanhamento();
	}
	
}
