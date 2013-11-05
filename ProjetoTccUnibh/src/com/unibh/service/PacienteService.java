/**
 * 
 */
package com.unibh.service;

import java.util.List;

import com.unibh.entities.paciente.Paciente;


/**
 * @author Andre
 *
 */
public interface PacienteService extends GenericService<Paciente> {

	public List<Paciente> getPacientes(String nome);

}
