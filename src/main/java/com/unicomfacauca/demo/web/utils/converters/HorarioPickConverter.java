/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicomfacauca.demo.web.utils.converters;

import com.unicomfacauca.demo.domain.entities.Horario;
import com.unicomfacauca.demo.domain.entities.dto.HorarioMatDTO;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.primefaces.component.picklist.PickList;
import org.primefaces.model.DualListModel;

/**
 *
 * @author danny
 */
@FacesConverter(forClass = com.unicomfacauca.demo.domain.entities.dto.HorarioMatDTO.class, value = "horarioPickConverter")
public class HorarioPickConverter implements Converter {

    @Override
    public HorarioMatDTO getAsObject(FacesContext context, UIComponent component, String value) {
        return getObjectFromUIPickListComponent(component, value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object object) {
        String string;
        if (object == null) {
            string = "";
        } else {
            try {
                string = String.valueOf(((HorarioMatDTO) object).getHorarioIni().getIdhorario());
            } catch (ClassCastException cce) {
                throw new ConverterException(cce.getMessage());
            }
        }
        return string;
    }

    @SuppressWarnings("unchecked")
    private HorarioMatDTO getObjectFromUIPickListComponent(UIComponent component, String value) {
        final DualListModel<HorarioMatDTO> dualList;
        try {
            dualList = (DualListModel<HorarioMatDTO>) ((PickList) component).getValue();
            HorarioMatDTO h = getObjectFromList(dualList.getSource(), Integer.valueOf(value));
            if (h == null) {
                h = getObjectFromList(dualList.getTarget(), Integer.valueOf(value));
            }

            return h;
        } catch (ClassCastException cce) {
            throw new ConverterException(cce.getMessage());
        } catch (NumberFormatException nfe) {
            throw new ConverterException(nfe.getMessage());
        }
    }

    private HorarioMatDTO getObjectFromList(final List<?> list, final Integer identifier) {
        for (final Object object : list) {
            final HorarioMatDTO h = (HorarioMatDTO) object;
            if (h.getHorarioIni().getIdhorario().equals(identifier)) {
                return h;
            }
        }
        return null;
    }

}
