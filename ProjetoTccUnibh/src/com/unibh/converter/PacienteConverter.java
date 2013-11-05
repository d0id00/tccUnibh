/**
 * 
 */
package com.unibh.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unibh.entities.paciente.Paciente;
import com.unibh.service.PacienteService;

/**
 * @author Andre
 *
 */
@Component("pacienteConverter")
public class PacienteConverter implements Converter {
	
	@Autowired
	private PacienteService pacienteService;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return pacienteService.getById(Integer.parseInt(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		Paciente paciente = (Paciente) value;
		return paciente.getId().toString();
	}

}
