/**
 * 
 */
package com.unibh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unibh.dao.RoleDAO;
import com.unibh.entities.role.Role;
import com.unibh.service.RoleService;

/**
 * @author Andre
 *
 */
@Service
public class RoleServiceImpl extends GenericServiceImpl<Role> implements RoleService {

	@Autowired
	private RoleDAO dao;

	@Override
	protected RoleDAO getDao() {
		return dao;
	}

}
