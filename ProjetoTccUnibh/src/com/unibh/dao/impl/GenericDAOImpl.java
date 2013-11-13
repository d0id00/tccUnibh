package com.unibh.dao.impl;
 
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.uaihebert.factory.EasyCriteriaFactory;
import com.uaihebert.model.EasyCriteria;
import com.unibh.dao.GenericDAO;
import com.unibh.entities.AbstractEntity;
import com.util.StringUtils;
 
@SuppressWarnings("unchecked")
public abstract class GenericDAOImpl<T extends AbstractEntity> implements GenericDAO<T> {
	
	@PersistenceContext(unitName="ProjetoTccUnibhPU")
    protected EntityManager entityManager;
	
    public T getById(Integer id) {
        return (T) entityManager.find(getTypeClass(), id);
    }
 
    public void save(T entity) {
        entityManager.persist(entity);
    }
 
	public void update(T entity) {
        try {
            entityManager.merge(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    public void delete(T entity) {
        try {
        	entity = getById(entity.getId());
            entityManager.remove(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    public void deleteById(Integer id) {
    	try {
    		T entity = getById(id);
    		entityManager.remove(entity);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public List<T> findAll() {
        return entityManager.createQuery(("From " + getTypeClass().getName()))
                .getResultList();
    }
    
    public void flush() {
    	entityManager.flush();
    }
    
	public T getByParam(String field, Object param) {
		if (!StringUtils.isEmptyOrNull(field) && param != null) {
			EasyCriteria<T> easy = EasyCriteriaFactory.createQueryCriteria(entityManager, getEntityClass());
			easy.andEquals(field, param);
			return easy.getSingleResult();
		}
		return null;
	}
    
	public List<T> getListByParam(String field, Object param) {
		if (!StringUtils.isEmptyOrNull(field) && param != null) {
			EasyCriteria<T> easy = EasyCriteriaFactory.createQueryCriteria(entityManager, getEntityClass());
			easy.andEquals(field, param);
			return easy.getResultList();
		}
		return null;
	}
	
    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        return clazz;
    }

	public Query createQuery(String query, Object... parameters) {
		Query q = entityManager.createQuery(query);
        for (int i = 1; i <= parameters.length; i++) {
            q.setParameter(i, parameters[i]);
        }
        return q;
	}

	public EasyCriteria<T> createEasyCriteria() {
		EasyCriteria<T> easy = EasyCriteriaFactory.createQueryCriteria(entityManager, getEntityClass());
		return easy;
	}

	protected abstract Class getEntityClass();
	
}