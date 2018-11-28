/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicomfacauca.demo.web.utils.converters;

import com.unicomfacauca.demo.domain.entities.Materia;
import com.unicomfacauca.demo.web.controller.MatriculaBean;
import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author danny
 */
@FacesConverter(forClass = com.unicomfacauca.demo.domain.entities.Materia.class, value = "materiaConverter")
public class MateriaConverter implements Converter {

    @Override
    public Materia getAsObject(FacesContext context, UIComponent component, String value) {

        ValueExpression vex
                = context.getApplication().getExpressionFactory()
                        .createValueExpression(context.getELContext(),
                                "#{matriculaBean}", MatriculaBean.class);
        MatriculaBean adBean = (MatriculaBean) vex.getValue(context.getELContext());
        return adBean.getCourse(Integer.valueOf(value));

    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {

        try {
            return ((Materia) o).getIdmateria().toString();
        } catch (NullPointerException e) {
            return "";
        }
    }

}
