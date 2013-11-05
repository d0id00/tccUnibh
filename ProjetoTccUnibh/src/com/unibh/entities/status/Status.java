/**
 * 
 */
package com.unibh.entities.status;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.util.Assert;

import com.unibh.entities.AbstractEntity;



/**
 * @author Andre
 *
 */
@SuppressWarnings("serial")
@Entity
public class Status extends AbstractEntity {

	public static final Integer STATUS_OPEN = 1;

	public static final Integer STATUS_CLOSED = 2;

	public static final Integer STATUS_ACTIVE = 3;

	public static final Integer STATUS_INACTIVE = 4;
	
	public static final String TYPE_STATUS_USER = "User";

	public static final String TYPE_STATUS_OTHER = "Other";

	public static final Status OPEN = new Status(STATUS_OPEN);

	public static final Status CLOSED = new Status(STATUS_CLOSED);

	public static final Status ACTIVE = new Status(STATUS_ACTIVE);

	public static final Status INACTIVE = new Status(STATUS_INACTIVE);

	public Status(Integer idStatus) {
		id = idStatus;
		nome = getName(id);
	}

	public static String getName(Integer idStatus) {
		Assert.notNull(idStatus);
		if (STATUS_OPEN.equals(idStatus)) {
			return "Aberto";
		}
		if (STATUS_CLOSED.equals(idStatus)) {
			return "Fechado";
		}
		if (STATUS_ACTIVE.equals(idStatus)) {
			return "Ativo";
		}
		if (STATUS_INACTIVE.equals(idStatus)) {
			return "Inativo";
		}
		throw new RuntimeException("Id status not found " + idStatus);
	}
	
	@Id
	@Column(name="idStatus")
	private Integer id;
	
	private String tipo;
	
	private String nome;

	public Status() {
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return getNome();
	}
	
}
