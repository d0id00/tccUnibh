/*
 * NIXSYS.
 * 
 * Link         www.nixsys.com.br
 * Copyright    all rights reserved. 
 * Project      ProjetoTccUnibh
 * Date         23/10/2013
 *
 */

package com.unibh.service.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.uaihebert.model.EasyCriteria;
import com.unibh.dao.GenericDAO;
import com.unibh.entities.AbstractEntity;
import com.unibh.service.GenericService;

/**
 * @author andre
 *
 */
@Transactional
public abstract class GenericServiceImpl<T extends AbstractEntity> implements GenericService<T> {

	@Override
	public void save(T entity) throws Exception {
		getDao().save(entity);
	}

	@Override
	public void update(T entity) throws Exception {
		getDao().update(entity);
	}

	@Override
	public void delete(T entity) {
		getDao().delete(entity);
	}

	@Override
	public void deleteById(Integer id) {
		getDao().deleteById(id);
	}

	@Override
	public T getById(Integer id) {
		return getDao().getById(id);
	}

	@Override
	public T getByParam(String field, Object param) {
		return getDao().getByParam(field, param);
	}

	@Override
	public List<T> getListByParam(String field, Object param) {
		return getDao().getListByParam(field, param);
	}
	
	@Override
	public List<T> findAll() {
		return getDao().findAll();
	}

	@Override
	public Query createQuery(String query, Object... parameters) {
		return getDao().createQuery(query, parameters);
	}

	@Override
	public EasyCriteria<T> createEasyCriteria() {
		return getDao().createEasyCriteria();
	}
	
	protected abstract GenericDAO<T> getDao();
	
}
