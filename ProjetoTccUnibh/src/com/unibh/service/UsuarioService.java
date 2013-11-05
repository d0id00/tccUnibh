/**
 * 
 */
package com.unibh.service;

import com.unibh.entities.usuario.Usuario;


/**
 * @author Andre
 *
 */
public interface UsuarioService extends GenericService<Usuario> {
	
	public Usuario getLogin(String login, String senha);

}
