/**
 * 
 */
package com.unibh.dao;

import java.util.List;

import com.unibh.entities.paciente.Paciente;

/**
 * @author Andre
 *
 */
public interface PacienteDAO extends GenericDAO<Paciente> {

	public List<Paciente> getPacientes(String nome);

}
