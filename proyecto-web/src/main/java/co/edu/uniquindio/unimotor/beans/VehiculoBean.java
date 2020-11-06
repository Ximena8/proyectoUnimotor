package co.edu.uniquindio.unimotor.beans;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import co.edu.uniquindio.unimotor.ejb.UnimotorEJB;
import co.edu.uniquindio.unimotor.entidades.Ciudad;
import co.edu.uniquindio.unimotor.entidades.Modelo;
import co.edu.uniquindio.unimotor.entidades.Persona;
import co.edu.uniquindio.unimotor.entidades.TipoCombustible;
import co.edu.uniquindio.unimotor.entidades.TipoVehiculo;
import co.edu.uniquindio.unimotor.entidades.Transmision;
import co.edu.uniquindio.unimotor.entidades.Vehiculo;

@Named
@ApplicationScoped
public class VehiculoBean {
	
	@EJB
	private UnimotorEJB unimotorEJB;
	private Vehiculo vehiculo;
	private List<TipoVehiculo> tiposVehiculos;
	private List<TipoCombustible> tiposCombustible;
	private List<Transmision> tiposTransmision;
	private Ciudad ciudad;
	private Persona persona;
	private Modelo modelo;
	
	@PostConstruct
	public void inicializar() {
		vehiculo = new Vehiculo();
		ciudad = unimotorEJB.obtenerCiudad(1);
		persona = unimotorEJB.obtenerPersona(1);
		modelo = unimotorEJB.obtenerModelo(1);
		
		tiposVehiculos = unimotorEJB.obtenerListaTiposVehiculos(); 
		tiposCombustible = unimotorEJB.obtenerListaTiposCombustible();
		tiposTransmision = unimotorEJB.obtenerListaTransmision();
	}
	
	public void registrarVehiculo() {
		try {
			vehiculo.setCiudad(ciudad);
			vehiculo.setPersona(persona);
			vehiculo.setModelo(modelo);
			vehiculo.setFechaPublicacion(new Date());
			unimotorEJB.registrarVehiculo(vehiculo);
			
			FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "¡Se ha registrado correctamente el vehiculo!");
			FacesContext.getCurrentInstance().addMessage("registro_vehiculo", msj);
		} catch (Exception e) {
			FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", "¡Se ha registrado correctamente el vehiculo!");
			FacesContext.getCurrentInstance().addMessage("registro_vehiculo", msj);
		}
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public List<TipoVehiculo> getTiposVehiculos() {
		return tiposVehiculos;
	}

	public void setTiposVehiculos(List<TipoVehiculo> tiposVehiculos) {
		this.tiposVehiculos = tiposVehiculos;
	}

	public List<TipoCombustible> getTiposCombustible() {
		return tiposCombustible;
	}

	public void setTiposCombustible(List<TipoCombustible> tiposCombustible) {
		this.tiposCombustible = tiposCombustible;
	}

	public List<Transmision> getTiposTransmision() {
		return tiposTransmision;
	}

	public void setTiposTransmision(List<Transmision> tiposTransmision) {
		this.tiposTransmision = tiposTransmision;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	
	

}
