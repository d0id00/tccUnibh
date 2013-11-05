/**
 * 
 */
package com.unibh.entities.internacao;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.unibh.entities.AbstractEntity;
import com.unibh.entities.acompanhamento.Acompanhamento;
import com.unibh.entities.paciente.Paciente;
import com.unibh.entities.status.Status;

/**
 * @author Andre
 *
 */
@Entity
public class Internacao extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "idInternacao")
	private Integer id;

	private Date dataInternacao;
	
	private Date dataReg;
	
	private String diagnostico;
	
	private String observacao;
	
	@ManyToOne
	@JoinColumn(name="idStatus")
	private Status status;

	@ManyToOne
	@JoinColumn(name="idPaciente")
	private Paciente paciente;
	
	@OneToOne(mappedBy = "internacao", cascade = CascadeType.ALL)
	@JoinColumn(name = "idAcompanhamento")
	private Acompanhamento acompanhamento;

	public Internacao() {
		dataReg = new Date();
		status = Status.OPEN;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataInternacao() {
		return dataInternacao;
	}

	public void setDataInternacao(Date dataInternacao) {
		this.dataInternacao = dataInternacao;
	}

	public Date getDataReg() {
		return dataReg;
	}

	public void setDataReg(Date dataReg) {
		this.dataReg = dataReg;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Acompanhamento getAcompanhamento() {
		return acompanhamento;
	}

	public void setAcompanhamento(Acompanhamento acompanhamento) {
		this.acompanhamento = acompanhamento;
	}

	@Override
	public String toString() {
		return getDiagnostico() + getPaciente().getNome();
	}

	public void calcStatus() {
		if (getAcompanhamento().isClosed()) {
			setStatus(Status.CLOSED);
		} else {
			setStatus(Status.OPEN);
		}
	}
	
}
