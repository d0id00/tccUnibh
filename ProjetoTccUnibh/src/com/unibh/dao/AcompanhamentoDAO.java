/**
 * 
 */
package com.unibh.dao;

import com.unibh.entities.acompanhamento.Acompanhamento;

/**
 * @author Andre
 *
 */
public interface AcompanhamentoDAO extends GenericDAO<Acompanhamento> {

	boolean existeAcompanhamento(Integer idInternacao);

}
