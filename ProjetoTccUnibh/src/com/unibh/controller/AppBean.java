/**
 * 
 */
package com.unibh.controller;

import javax.faces.bean.ApplicationScoped;

import org.springframework.stereotype.Controller;

import com.util.Util;

/**
 * @author Andre
 *
 */
@Controller
@ApplicationScoped
public class AppBean {

	public AppBean() {
	}
	
	public String getBaseUrl() {
		return Util.baseurl();
	}

	public String getBasePath() {
		return Util.basepath();
	}
	
}
