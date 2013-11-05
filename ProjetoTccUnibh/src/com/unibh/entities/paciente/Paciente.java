/**
 * 
 */
package com.unibh.entities.paciente;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.unibh.entities.AbstractEntity;
import com.unibh.entities.internacao.Internacao;
import com.unibh.entities.usuario.Usuario;

/**
 * @author Andre
 *
 */
@Entity
public class Paciente extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "idPaciente")
	private Integer id;

	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;
	
	@Column(unique = true, nullable = false)
	private String nome;
	
	private double peso;
	
	private double altura;
	
	private double imc;
	
	private Integer idade;
	
	private Date dataReg;
	
	@OneToMany
	private Set<Internacao> internacoes;

	public Paciente() {
		this.dataReg = new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getImc() {
		return imc;
	}

	public void setImc(double imc) {
		this.imc = imc;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Date getDataReg() {
		return dataReg;
	}

	public void setDataReg(Date dataReg) {
		this.dataReg = dataReg;
	}

	//@JoinTable(name = "PAC_INT", joinColumns=@JoinColumn(name = "PAC_ID"), inverseJoinColumns=@JoinColumn(name = "INT_ID"))
	public Set<Internacao> getInternacoes() {
		if (internacoes == null) {
			internacoes = new HashSet<Internacao>();
		}
		return internacoes;
	}

	public void setInternacoes(Set<Internacao> internacoes) {
		this.internacoes = internacoes;
	}

	@Override
	public String toString() {
		return getNome();
	}
	
}
