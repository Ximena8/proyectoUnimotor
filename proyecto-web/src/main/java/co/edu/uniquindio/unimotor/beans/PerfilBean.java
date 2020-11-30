package co.edu.uniquindio.unimotor.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.annotation.ManagedProperty;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import co.edu.uniquindio.unimotor.ejb.UnimotorEJB;
import co.edu.uniquindio.unimotor.entidades.Persona;
import co.edu.uniquindio.unimotor.entidades.Vehiculo;

@Named
@ViewScoped
public class PerfilBean implements Serializable{
    
	@EJB
	private UnimotorEJB unimotorEJB;
	@Inject
	@ManagedProperty(value="#{seguridadBean.persona}")
	private Persona persona;
	private List<Vehiculo> misVehiculos;
	private static final long serialVersionUID = 1L;
	
	@PostConstruct
	public void inicializar() {
		
		if(persona!=null) {
			misVehiculos = unimotorEJB.obtenerListaVehiculosPersona(persona.getId());
		}
	}
	
	public void editarPerfil() {
		
	}
	
	public void ObtenerListaFavoritos() {
		
	}
	
	public String editarVehiculo(String id) {
		return "/editarVehiculo?faces-redirect=true&amp;vehiculo="+id;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Vehiculo> getMisVehiculos() {
		return misVehiculos;
	}

	public void setMisVehiculos(List<Vehiculo> misVehiculos) {
		this.misVehiculos = misVehiculos;
	}
	
	

}
