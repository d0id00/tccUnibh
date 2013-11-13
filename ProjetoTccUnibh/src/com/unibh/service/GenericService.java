/*
 * NIXSYS.
 * 
 * Link         www.nixsys.com.br
 * Copyright    all rights reserved. 
 * Project      ProjetoTccUnibh
 * Date         23/10/2013
 *
 */

package com.unibh.service;

import java.util.List;

import javax.persistence.Query;

import com.uaihebert.model.EasyCriteria;
import com.unibh.entities.AbstractEntity;

/**
 * @author andre
 *
 */
public interface GenericService<T extends AbstractEntity> {

	void save(T entity) throws Exception;
		 
    void update(T entity) throws Exception;
 
    void delete(T entity) throws Exception;
 
    void deleteById(Integer id);
    
    void flush();
 
    T getById(Integer id);
    
    T getByParam(String field, Object param);
    
    List<T> getListByParam(String field, Object param);
 
    List<T> findAll();
     
    Query createQuery(String query, Object... parameters);

	EasyCriteria<T> createEasyCriteria();
	    
}