/**
 * 
 */
package com.unibh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unibh.dao.UsuarioDAO;
import com.unibh.entities.usuario.Usuario;
import com.unibh.service.UsuarioService;

/**
 * @author Andre
 *
 */
@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario> implements UsuarioService {

	@Autowired
	private UsuarioDAO dao;

	@Override
	protected UsuarioDAO getDao() {
		return dao;
	}

	@Override
	public Usuario getLogin(String login, String senha) {
		return dao.getLogin(login, senha);
	}

}
