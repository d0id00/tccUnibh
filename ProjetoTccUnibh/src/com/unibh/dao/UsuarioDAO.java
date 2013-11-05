/**
 * 
 */
package com.unibh.dao;

import com.unibh.entities.usuario.Usuario;

/**
 * @author Andre
 *
 */
public interface UsuarioDAO extends GenericDAO<Usuario> {

	public Usuario getLogin(String login, String senha);
	
}
