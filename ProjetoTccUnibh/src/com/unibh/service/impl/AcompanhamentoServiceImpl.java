/**
 * 
 */
package com.unibh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unibh.dao.AcompanhamentoDAO;
import com.unibh.dao.InternacaoDAO;
import com.unibh.entities.acompanhamento.Acompanhamento;
import com.unibh.service.AcompanhamentoService;

/**
 * @author Andre
 *
 */
@Service
public class AcompanhamentoServiceImpl extends GenericServiceImpl<Acompanhamento> implements AcompanhamentoService {

	@Autowired
	private AcompanhamentoDAO dao;
	
	@Autowired
	private InternacaoDAO interdao;

	@Override
	protected AcompanhamentoDAO getDao() {
		return dao;
	}

	@Override
	public void save(Acompanhamento entity) throws Exception {
		entity.checkFields();
		if (!dao.existeAcompanhamento(entity.getInternacao().getId())) {
			super.save(entity);
		} else {
			throw new Exception("Erro. já existe um acompanhamento vinculado a esta internação.");
		}
	}
	
	@Override
	public void update(Acompanhamento entity) throws Exception {
		entity.checkStatus();
		entity.checkFields();
		entity.calcStatus();
		super.update(entity);
	}
	
	@Override
	public void delete(Acompanhamento entity) throws Exception {
		entity.checkStatus();
		super.delete(entity);
	}
	
}
