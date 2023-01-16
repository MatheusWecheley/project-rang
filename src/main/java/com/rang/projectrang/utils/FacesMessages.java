package com.rang.projectrang.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;

public class FacesMessages implements Serializable {

    private void add(String msg, FacesMessage.Severity severity) {
        FacesMessage facesMessage = new FacesMessage(msg);
        facesMessage.setSeverity(severity);

        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }

    public void info(String msg) {
        add(msg, FacesMessage.SEVERITY_INFO);
    }

    public void warn(String msg) {
        add(msg, FacesMessage.SEVERITY_WARN);
    }
}