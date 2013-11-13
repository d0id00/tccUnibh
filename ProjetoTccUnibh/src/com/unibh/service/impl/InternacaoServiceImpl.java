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

	@Override
	public Internacao hasInternacaoAbertaParaPaciente(Integer idPaciente) {
		return dao.hasInternacaoAbertaParaPaciente(idPaciente);
	}
	
	@Override
	public void save(Internacao entity) throws Exception {
		if (hasInternacaoAbertaParaPaciente(entity.getPaciente().getId()) != null) {
			throw new Exception("Erro. Já existe uma internação aberta para o paciente " + entity.getPaciente().getNome());
		} 
		super.save(entity);
	}
	
	@Override
	public void update(Internacao entity) throws Exception {
		entity.checkStatus();
		super.update(entity);
	}
	
	@Override
	public void delete(Internacao entity) throws Exception {
		entity.checkStatus();
		super.delete(entity);
	}

}
