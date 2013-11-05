/**
 * 
 */
package com.unibh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unibh.dao.StatusDAO;
import com.unibh.entities.status.Status;
import com.unibh.service.StatusService;

/**
 * @author Andre
 *
 */
@Service
public class StatusServiceImpl extends GenericServiceImpl<Status> implements StatusService {

	@Autowired
	private StatusDAO dao;

	@Override
	protected StatusDAO getDao() {
		return dao;
	}

}
