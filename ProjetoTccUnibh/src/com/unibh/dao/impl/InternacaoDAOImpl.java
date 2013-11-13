/**
 * 
 */
package com.unibh.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

import com.uaihebert.model.EasyCriteria;
import com.unibh.dao.InternacaoDAO;
import com.unibh.entities.internacao.Internacao;
import com.unibh.entities.status.Status;

/**
 * @author Andre
 *
 */
@Repository
public class InternacaoDAOImpl extends GenericDAOImpl<Internacao> implements InternacaoDAO {

	@Override
	protected Class getEntityClass() {
		return Internacao.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Internacao> getInternacoesAbertas(String value) {
		Query query = entityManager
				.createQuery("Select i from Internacao i where i.diagnostico like '%"
						+ value + "%' and i.status = '"+ Status.STATUS_OPEN +"'"); 
		return query.getResultList();
	}

	@Override
	public Internacao hasInternacaoAbertaParaPaciente(Integer idPaciente) {
		try {
			EasyCriteria<Internacao> easy = createEasyCriteria();
			easy.andEquals("paciente", idPaciente);
			easy.andEquals("status", Status.OPEN);
			return easy.getSingleResult();
		} catch (Exception e) {
		}
		return null;
	}

}
