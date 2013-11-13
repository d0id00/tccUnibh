/**
 * 
 */
package com.unibh.dao;

import java.util.List;

import com.unibh.entities.internacao.Internacao;

/**
 * @author Andre
 *
 */
public interface InternacaoDAO extends GenericDAO<Internacao> {

	public List<Internacao> getInternacoesAbertas(String value);

	public Internacao hasInternacaoAbertaParaPaciente(Integer idPaciente);

}
