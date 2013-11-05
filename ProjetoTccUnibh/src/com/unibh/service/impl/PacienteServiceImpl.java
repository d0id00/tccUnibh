/**
 * 
 */
package com.unibh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unibh.dao.PacienteDAO;
import com.unibh.entities.paciente.Paciente;
import com.unibh.service.PacienteService;

/**
 * @author Andre
 *
 */
@Service
public class PacienteServiceImpl extends GenericServiceImpl<Paciente> implements PacienteService {

	@Autowired
	private PacienteDAO dao;

	@Override
	protected PacienteDAO getDao() {
		return dao;
	}

	@Override
	public List<Paciente> getPacientes(String nome) {
		return dao.getPacientes(nome);
	}

}
