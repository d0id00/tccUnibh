/**
 * 
 */
package com.unibh.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unibh.entities.status.Status;
import com.unibh.service.StatusService;

/**
 * @author Andre
 *
 */
@Component("statusConverter")
public class StatusConverter implements Converter {
	
	@Autowired
	private StatusService statusService;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (!"".equals(value)) {
			return statusService.getById(Integer.parseInt(value));
		}
		return value;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (!"".equals(value)) {
			Status status = (Status) value;
			return status.getId().toString();
		}
		return "";
	}

}
