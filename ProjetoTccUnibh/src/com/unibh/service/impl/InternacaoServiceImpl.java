/**
 * 
 */
package com.unibh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unibh.dao.InternacaoDAO;
import com.unibh.entities.internacao.Internacao;
import com.unibh.service.InternacaoService;

/**
 * @author Andre
 *
 */
@Service
public class InternacaoServiceImpl extends GenericServiceImpl<Internacao> implements InternacaoService {

	@Autowired
	private InternacaoDAO dao;

	@Override
	protected InternacaoDAO getDao() {
		return dao;
	}

	@Override
	public List<Internacao> getInternacoesAbertas(String value) {
		return dao.getInternacoesAbertas(value);
	}

}
