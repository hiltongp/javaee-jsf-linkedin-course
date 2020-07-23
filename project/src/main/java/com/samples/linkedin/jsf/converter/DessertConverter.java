/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samples.linkedin.jsf.converter;

import com.samples.linkedin.jsf.dao.DessertLoaderDAO;
import com.samples.linkedin.jsf.dto.Dessert;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Hilton Girardi Presa
 */
@FacesConverter(forClass=Dessert.class)
@Named("dessertConverter")
@RequestScoped
public class DessertConverter implements Converter{

    @Inject
    DessertLoaderDAO dessertDao;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null){
            try{
                return dessertDao.findDessertByName(value);
            } catch (Exception e){
                throw new ConverterException(new FacesMessage(e.getMessage()));
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null && value instanceof Dessert ){
            return ((Dessert) value).getDessertName();
        }
        return null;
    }
    
}
