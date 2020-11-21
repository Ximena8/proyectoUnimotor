package co.edu.uniquindio.unimotor.converter;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

import co.edu.uniquindio.unimotor.ejb.UnimotorEJB;
import co.edu.uniquindio.unimotor.entidades.Modelo;

@Named
@ApplicationScoped
public class ModeloConverter implements Converter<Modelo>, Serializable {

	@EJB 
	private UnimotorEJB unimotorEJB;
	
	private static final long serialVersionUID = 1L;

	@Override
	public Modelo getAsObject(FacesContext context, UIComponent component, String value) {
		Modelo modelo = null;
		
		if(value!=null) {
			
			modelo = unimotorEJB.obtenerModelo(Integer.parseInt(value));
		}
		
		return modelo;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Modelo value) {
		if(value!=null) {
			
			return String.format("%d",value.getId());
		}
		return "";
	}

}
