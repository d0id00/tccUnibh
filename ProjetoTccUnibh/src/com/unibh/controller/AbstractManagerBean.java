/**
 * 
 */
package com.unibh.controller;

import java.io.Serializable;

import com.util.JSFMessageUtil;

/**
 * @author d0id00
 *
 */
@SuppressWarnings("serial")
public class AbstractManagerBean implements Serializable {
	
//    private static final String KEEP_DIALOG_OPENED = "KEEP_DIALOG_OPENED";

    public AbstractManagerBean() {
	}

    protected void displayErrorMessageToUser(String message) {
        JSFMessageUtil messageUtil = new JSFMessageUtil();
        messageUtil.sendErrorMessageToUser(message);
    }
 
    protected void displayInfoMessageToUser(String message) {
        JSFMessageUtil messageUtil = new JSFMessageUtil();
        messageUtil.sendInfoMessageToUser(message);
    }
 
//    protected void closeDialog(){
//        getRequestContext().addCallbackParam(KEEP_DIALOG_OPENED, false);
//    }
// 
//    protected void keepDialogOpen(){
//        getRequestContext().addCallbackParam(KEEP_DIALOG_OPENED, true);
//    }
// 
//    protected RequestContext getRequestContext(){
//        return RequestContext.getCurrentInstance();
//    }
}
