/**
 * 
 */
package com.unibh.service;

import java.util.List;

import com.unibh.entities.internacao.Internacao;



/**
 * @author Andre
 *
 */
public interface InternacaoService extends GenericService<Internacao> {

	public List<Internacao> getInternacoesAbertas(String value);
	
	public Internacao hasInternacaoAbertaParaPaciente(Integer idPaciente);
	
}
