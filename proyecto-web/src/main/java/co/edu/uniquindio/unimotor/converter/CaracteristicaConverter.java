package co.edu.uniquindio.unimotor.converter;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

import co.edu.uniquindio.unimotor.ejb.UnimotorEJB;
import co.edu.uniquindio.unimotor.entidades.Caracteristicas;


@Named
@ApplicationScoped
public class CaracteristicaConverter implements Converter<Caracteristicas>, Serializable {
	
	@EJB 
	private UnimotorEJB unimotorEJB;
	private static final long serialVersionUID = 1L;
    
	@Override
	public Caracteristicas getAsObject(FacesContext context, UIComponent component, String value) {
		Caracteristicas car = null;
		
		if(value!=null) {
			
			car = unimotorEJB.obtenerCaracteristica(Integer.parseInt(value));
		}
		
		return car;
	}
	@Override
	public String getAsString(FacesContext context, UIComponent component,Caracteristicas value) {
		if(value!=null) {
			
			return String.format("%d",value.getId());
		}
		return "";
	}

}
