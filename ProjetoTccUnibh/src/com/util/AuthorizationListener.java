/*
 * NIXSYS.
 * 
 * Link         www.nixsys.com.br
 * Copyright    all rights reserved. 
 * Project      ProjetoTccUnibh
 * Date         23/10/2013
 *
 */

package com.util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

/**
 * @author andre
 *
 */
public class AuthorizationListener implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext facesContext = event.getFacesContext();
		String currentPage = facesContext.getViewRoot().getViewId();
		boolean isLoginPage = (currentPage.lastIndexOf("login.xhtml") > -1) ? true : false;
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
		Object usuario = session.getAttribute("usuario");
		if (!isLoginPage && usuario == null) {
			NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
			nh.handleNavigation(facesContext, null, "loginPage");
		}
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}
	
}
