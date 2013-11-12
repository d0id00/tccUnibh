/**
 * 
 */
package com.unibh.entities.acompanhamento;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.unibh.entities.AbstractEntity;
import com.unibh.entities.internacao.Internacao;
import com.unibh.entities.status.Status;

/**
 * @author Andre
 *
 */
/**
 * @author Andre
 *
 */
@Entity
@Table(name = "acompanhamento")
public class Acompanhamento extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "idAcompanhamento")
	private Integer id;

	private Date dataReg;
	
	private Date dataAcompanhamento;
	
	private String viaAdministracao;
	
	private String desfecho;
	
	private String observacao;
	
	@OneToOne
	@JoinColumn(name = "idInternacao")
	private Internacao internacao;
	
	@ManyToOne
	@JoinColumn(name="idStatus")
	private Status status;

	public Acompanhamento() {
		dataReg = new Date();
		status = Status.OPEN;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataAcompanhamento() {
		return dataAcompanhamento;
	}

	public void setDataAcompanhamento(Date dataAcompanhamento) {
		this.dataAcompanhamento = dataAcompanhamento;
	}

	public Date getDataReg() {
		return dataReg;
	}

	public void setDataReg(Date dataReg) {
		this.dataReg = dataReg;
	}

	public String getViaAdministracao() {
		return viaAdministracao;
	}

	public void setViaAdministracao(String viaAdministracao) {
		this.viaAdministracao = viaAdministracao;
	}

	public String getDesfecho() {
		return desfecho;
	}

	public void setDesfecho(String desfecho) {
		this.desfecho = desfecho;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Internacao getInternacao() {
		return internacao;
	}

	public void setInternacao(Internacao internacao) {
		this.internacao = internacao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void calcStatus() throws Exception {
		if(Status.CLOSED.equals(getStatus())) {
			checkDesfecho();
			setStatus(Status.CLOSED);
		} else {
			setStatus(Status.OPEN);
		}
		getInternacao().calcStatus();
	}
	
	private void checkDesfecho() throws Exception {
		if (getDesfecho().isEmpty()) {
			throw new Exception("Erro. Favor informar o desfecho do paciente.");
		}
	}

	public void checkFields() throws Exception {
		if (getDataAcompanhamento() == null) {
			throw new Exception("Erro. Favor informar a data de acompanhamento do paciente.");
		}
		if (getDataAcompanhamento().compareTo(new Date()) > 0) {
			throw new Exception("Erro. A data de acompanhamento do paciente deverá ser menor que a data atual.");
		}
		if (getViaAdministracao().isEmpty()) {
			throw new Exception("Erro. Favor informar a via de administração do paciente.");
		}
		if (getObservacao().isEmpty()) {
			throw new Exception("Erro. Favor informar as observações referentes ao paciente.");
		}
		if (getStatus() == null) {
			throw new Exception("Erro. Favor informar status do acompanhamento do paciente.");
		}
		if (getInternacao() == null) {
			throw new Exception("Erro. Favor informar o diagnóstico de internação do paciente.");
		}
	}

	public boolean isClosed() {
		return Status.CLOSED.equals(getStatus());
	}

	public boolean isOpen() {
		return Status.OPEN.equals(getStatus());
	}

}
