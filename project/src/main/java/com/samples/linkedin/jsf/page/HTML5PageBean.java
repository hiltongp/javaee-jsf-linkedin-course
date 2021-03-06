/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samples.linkedin.jsf.page;

import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Eyitayo
 */
@Named("html5Bean")
@RequestScoped
public class HTML5PageBean {
    
    private String dateIn;
    private Date dateObjectIn;
    private String dateOut;
    
    
    public void transformDates(){
        setDateOut(getDateIn());
    }

    /**
     * @return the dateIn
     */
    public String getDateIn() {
        return dateIn;
    }

    /**
     * @param dateIn the dateIn to set
     */
    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    /**
     * @return the dateOut
     */
    public String getDateOut() {
        return dateOut;
    }

    /**
     * @param dateOut the dateOut to set
     */
    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    /**
     * @return the dateObjectIn
     */
    public Date getDateObjectIn() {
        return dateObjectIn;
    }

    /**
     * @param dateObjectIn the dateObjectIn to set
     */
    public void setDateObjectIn(Date dateObjectIn) {
        this.dateObjectIn = dateObjectIn;
    }
    
}