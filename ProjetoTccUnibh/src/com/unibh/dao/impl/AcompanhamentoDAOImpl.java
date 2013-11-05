/**
 * 
 */
package com.unibh.dao.impl;

import org.springframework.stereotype.Repository;

import com.uaihebert.model.EasyCriteria;
import com.unibh.dao.AcompanhamentoDAO;
import com.unibh.entities.acompanhamento.Acompanhamento;

/**
 * @author Andre
 *
 */
@Repository
public class AcompanhamentoDAOImpl extends GenericDAOImpl<Acompanhamento> implements AcompanhamentoDAO {

	@Override
	protected Class getEntityClass() {
		return Acompanhamento.class;
	}

	@Override
	public boolean existeAcompanhamento(Integer idInternacao) {
		try {
			EasyCriteria<Acompanhamento> easy = createEasyCriteria();
			easy.andEquals("internacao", idInternacao);
			return easy.getSingleResult() == null ? false : true; 
		} catch (Exception e) {
			return false;
		}
	}

}
