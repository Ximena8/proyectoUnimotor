package co.edu.uniquindio.unimotor.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.annotation.FacesConfig.Version;
import javax.faces.annotation.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;

import co.edu.uniquindio.unimotor.ejb.UnimotorEJB;
import co.edu.uniquindio.unimotor.entidades.Vehiculo;

@FacesConfig(version = Version.JSF_2_3)
@Named
@RequestScoped
public class BusquedaBean {
	
	@EJB
	private UnimotorEJB clienteEJB;
	private String busqueda;
	private List<Vehiculo> lista;
	
	@Inject
	@ManagedProperty(value = "#{param.busqueda}")
	private  String busquedaParam;
	
	@PostConstruct
	public void inicializar() {
		
		if(busquedaParam != null) {
			lista = clienteEJB.buscarVehiculos(busquedaParam);
		}

	}
	
	
	public String buscar() {
	 
//	System.out.println(lista);
		return "resultadoBusqueda?faces-redirect=true&amp;busqueda="+busqueda;
	}
	
	
	public String getBusqueda() {
		return busqueda;
	}

	public void setBusqueda(String busqueda) {
		this.busqueda = busqueda;
	}

	public List<Vehiculo> getLista() {
		return lista;
	}

	public void setLista(List<Vehiculo> lista) {
		this.lista = lista;
	}


	public String getBusquedaParam() {
		return busquedaParam;
	}


	public void setBusquedaParam(String busquedaParam) {
		this.busquedaParam = busquedaParam;
	}

	
	
}
