package co.edu.uniquindio.unimotor.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import co.edu.uniquindio.unimotor.ejb.UnimotorEJB;
import co.edu.uniquindio.unimotor.entidades.Vehiculo;

@Named
@ViewScoped
public class InicioBean implements Serializable{
    
	@EJB
	private UnimotorEJB unimotorEJB;
	private List<Vehiculo> vehiculos;
	private static final long serialVersionUID = 1L;
	
	@PostConstruct
	public void inicializar() {
		
		vehiculos = unimotorEJB.obtenerListaVehiculos();
	}
	
	public String irAlDetalle(String id) {
		return"detalleVehiculo?faces-redirect=true&amp;vehiculo="+id;
	}
	
	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}
	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	
	
	

}
