/**
 * 
 */
package com.unibh.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unibh.entities.internacao.Internacao;
import com.unibh.service.InternacaoService;

/**
 * @author Andre
 *
 */
@Component("internacaoConverter")
public class InternacaoConverter implements Converter {
	
	@Autowired
	private InternacaoService internacaoService;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return internacaoService.getById(Integer.parseInt(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		Internacao internacao = (Internacao) value;
		return internacao.getId().toString();
	}

}
