/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samples.linkedin.jsf.validator;

import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Hilton Girardi Presa
 */
@FacesValidator("selectValidator")
public class SampleCustomValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
         boolean foundSelect = Pattern.compile(Pattern.quote("select"),Pattern.CASE_INSENSITIVE).matcher(value.toString()).find();
        if(foundSelect){
            throw new ValidatorException(new FacesMessage("Validation error: we found the word: SELECT"));
        }
    }
    
}
