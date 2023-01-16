package com.rang.projectrang.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;

public class FacesMessages implements Serializable {

    //Metódo de para adicionar mensagens e informa-los no front-end, passando a mensagem como parametro e adicionado na instancia do FacesContext
    private void add(String msg, FacesMessage.Severity severity) {
        FacesMessage facesMessage = new FacesMessage(msg);
        facesMessage.setSeverity(severity);

        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }

    //Metódo para mostrar uma mensagem como informação
    public void info(String msg) {
        add(msg, FacesMessage.SEVERITY_INFO);
    }

    //Metódo para mostrar uma mensagem como "Atenção"
    public void warn(String msg) {
        add(msg, FacesMessage.SEVERITY_WARN);
    }
}
