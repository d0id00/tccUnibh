/**
 * 
 */
package com.unibh.dao.impl;

import org.springframework.stereotype.Repository;

import com.unibh.dao.StatusDAO;
import com.unibh.entities.status.Status;

/**
 * @author Andre
 *
 */
@Repository
public class StatusDAOImpl extends GenericDAOImpl<Status> implements StatusDAO {

	@Override
	protected Class getEntityClass() {
		return Status.class;
	}

}
