/**
 * 
 */
package com.unibh.dao;

import java.util.List;

import javax.persistence.Query;

import com.uaihebert.model.EasyCriteria;
import com.unibh.entities.AbstractEntity;

/**
 * @author Andre
 *
 */
public interface GenericDAO<T extends AbstractEntity> {

	void save(T entity);
	 
    void update(T entity);
 
    void delete(T entity);
 
    void deleteById(Integer id);
 
    T getById(Integer id);
    
    T getByParam(String field, Object param);
    
    List<T> getListByParam(String field, Object param);
 
    List<T> findAll();
     
    Query createQuery(String query, Object... parameters);
    
    EasyCriteria<T> createEasyCriteria();
    
}
