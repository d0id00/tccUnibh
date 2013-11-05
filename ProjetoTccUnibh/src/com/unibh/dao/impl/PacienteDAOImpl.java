/**
 * 
 */
package com.unibh.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uaihebert.model.EasyCriteria;
import com.unibh.dao.PacienteDAO;
import com.unibh.entities.paciente.Paciente;

/**
 * @author Andre
 *
 */
@Repository
public class PacienteDAOImpl extends GenericDAOImpl<Paciente> implements PacienteDAO {

	@Override
	protected Class getEntityClass() {
		return Paciente.class;
	}

	@Override
	public List<Paciente> getPacientes(String nome) {
		EasyCriteria<Paciente> easyCriteria = createEasyCriteria();
		easyCriteria.andStringLike("nome", "%"+nome+"%");
		return easyCriteria.getResultList();
	}
	
}
