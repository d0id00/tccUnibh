/**
 * 
 */
package com.unibh.dao.impl;

import org.springframework.stereotype.Repository;

import com.unibh.dao.RoleDAO;
import com.unibh.entities.role.Role;

/**
 * @author Andre
 *
 */
@Repository
public class RoleDAOImpl extends GenericDAOImpl<Role> implements RoleDAO {

	@Override
	protected Class getEntityClass() {
		return Role.class;
	}

}
