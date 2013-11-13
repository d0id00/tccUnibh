/**
 * 
 */
package com.unibh.controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.unibh.entities.usuario.Usuario;
import com.unibh.service.UsuarioService;
import com.util.Util;

/**
 * @author Andre
 *
 */
@SuppressWarnings("serial")
@Controller
@SessionScoped
public class LoginBean extends AbstractManagerBean {
	
	private Usuario usuario;
	
	private @Autowired UsuarioService usuarioService;

	@PostConstruct
	private void init() {
		usuario = new Usuario();
	}
  
    public void login() {
        RequestContext context = RequestContext.getCurrentInstance();  
        FacesMessage msg = null;  
        boolean loggedIn = false;
        String url = "";
        this.usuario = usuarioService.getLogin(usuario.getLogin(), usuario.getSenha());
        if(this.usuario != null) {
	        loggedIn = true;
	        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario.getLogin());
	        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem Vindo ", this.usuario.getNome());
	        url = Util.basepathlogin()+"pages/public/inicio.jsf";
		} else {  
	        loggedIn = false;  
	        msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");
	        if (usuario == null) {
	        	usuario = new Usuario();
	        }
	    }  
	    FacesContext.getCurrentInstance().addMessage(null, msg);  
	    context.addCallbackParam("loggedIn", loggedIn);  
	    context.addCallbackParam("url", url);  
    }
    
    public void logout() {
    	String url = Util.basepathlogin()+"login.jsf";
    	RequestContext context = RequestContext.getCurrentInstance();
    	FacesContext facesContext = FacesContext.getCurrentInstance();
    	HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
    	session.invalidate();
    	context.addCallbackParam("loggerOut", true);
    	context.addCallbackParam("url", url);
    }

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
    
}
