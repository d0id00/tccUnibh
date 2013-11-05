/**
 * 
 */
package com.unibh.dao.impl;

import org.springframework.stereotype.Repository;

import com.uaihebert.model.EasyCriteria;
import com.unibh.dao.UsuarioDAO;
import com.unibh.entities.usuario.Usuario;

/**
 * @author Andre
 *
 */
@Repository
public class UsuarioDAOImpl extends GenericDAOImpl<Usuario> implements UsuarioDAO {

	@Override
	protected Class getEntityClass() {
		return Usuario.class;
	}

	@Override
	public Usuario getLogin(String login, String senha) {
		try {
			EasyCriteria<Usuario> easyCriteria = createEasyCriteria();
			easyCriteria.andEquals("login", login).andEquals("senha", senha);
			return easyCriteria.getSingleResult();
		} catch (Exception e) {
		}
		return null;
	}
	
}
