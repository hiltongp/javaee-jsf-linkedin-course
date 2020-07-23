/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samples.linkedin.jsf.page;

import com.samples.linkedin.jsf.bean.SampleViewScopedBean;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Hilton Girardi Presa
 */
@Named("welcomePageBean")
@RequestScoped
public class WelcomePageBean {
    
    private String welcomeUserName;
    private String completedGreeting;
    
    @Inject
    SampleViewScopedBean viewBean;

    public String getWelcomeUserName() {
        return welcomeUserName;
    }

    public void setWelcomeUserName(String welcomeUserName) {
        this.welcomeUserName = welcomeUserName;
    }

    public String getCompletedGreeting() {
        return completedGreeting;
    }

    public void setCompletedGreeting(String completedGreeting) {
        this.completedGreeting = completedGreeting;
    }
    
    public void sayHello(){
        completedGreeting = "Hello, " + welcomeUserName;
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, completedGreeting, "Olá você, tudo bem");
        FacesContext.getCurrentInstance().addMessage("inputTextBox", message);
    }
    
    public String navigateToFlashScopePage(){
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("transmittedVariable", viewBean.getDogs().get(0));
        return "flashscope.xhtml?faces-redirect=true";
    }
    
    public void ajaxTriggered(){
        Logger.getAnonymousLogger().info("this is a ajax-triggered log statement");
    }
    
    public void alsoAjaxTriggered(AjaxBehaviorEvent aeb){
        
    }
    
    public void isRefeshed(){
        FacesContext.getCurrentInstance().isPostback();
        FacesContext.getCurrentInstance().validationFailed();
    }
            
}
