package co.edu.uniquindio.unimotor.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import co.edu.uniquindio.unimotor.ejb.UnimotorEJB;
import co.edu.uniquindio.unimotor.entidades.Ciudad;
import co.edu.uniquindio.unimotor.entidades.Persona;

@Named
@ViewScoped
public class PersonaBean implements Serializable {
	
	
	@EJB
	private UnimotorEJB unimotorEJB;
	private Persona persona;
	private Ciudad ciudad;
	
	private static final long serialVersionUID = 1L;
	
	@PostConstruct
	public void inicializar() {
		
		ciudad= unimotorEJB.obtenerCiudad(7);
		persona = new Persona();
		
		
	}
	
	public void resgistrarPersona() {
		
		
		try {
			persona.setCiudad(ciudad);
			unimotorEJB.registrarPersona(persona);
			
			FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "¡ Registro existoso !");
			FacesContext.getCurrentInstance().addMessage("registro_persona", msj);
			
			
		} catch (Exception e) {
			FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
			FacesContext.getCurrentInstance().addMessage("registro_persona", msj);
			
		}
		
		
		
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
