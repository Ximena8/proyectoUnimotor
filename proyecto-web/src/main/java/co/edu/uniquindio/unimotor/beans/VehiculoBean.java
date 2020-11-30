package co.edu.uniquindio.unimotor.beans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.annotation.ManagedProperty;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

import co.edu.uniquindio.unimotor.ejb.UnimotorEJB;
import co.edu.uniquindio.unimotor.entidades.Caracteristicas;
import co.edu.uniquindio.unimotor.entidades.Ciudad;
import co.edu.uniquindio.unimotor.entidades.Modelo;
import co.edu.uniquindio.unimotor.entidades.Persona;
import co.edu.uniquindio.unimotor.entidades.TipoCombustible;
import co.edu.uniquindio.unimotor.entidades.TipoVehiculo;
import co.edu.uniquindio.unimotor.entidades.Transmision;
import co.edu.uniquindio.unimotor.entidades.Vehiculo;

@Named
@ViewScoped
public class VehiculoBean implements Serializable {
	
	
	@EJB
	private UnimotorEJB unimotorEJB;
	private Vehiculo vehiculo;
	private List<TipoVehiculo> tiposVehiculos;
	private List<TipoCombustible> tiposCombustible;
	private List<Transmision> tiposTransmision;
	
	@Inject
	@ManagedProperty(value="#{seguridadBean.persona}")
	private Persona persona;
	private List<Ciudad> ciudades;
	private List<Modelo> modelos;
	private ArrayList<String> imagenes;
	private List<Caracteristicas> caracteristicas;
	private static final String RUTA_FOTOS = "C:\\Users\\payara5\\glassfish\\domains\\domain1\\docroot\\unimotor\\";
	
	private static final long serialVersionUID = 1L;
	
	@PostConstruct
	public void inicializar() {
	    vehiculo = new Vehiculo();
	    imagenes = new ArrayList<String>();
	    ciudades = unimotorEJB.obtenerListaCidades();
	    caracteristicas = unimotorEJB.obtenerListaCaracteristicas();
		modelos=unimotorEJB.obtenerListaModelos();
		tiposVehiculos = unimotorEJB.obtenerListaTiposVehiculos(); 
		tiposCombustible = unimotorEJB.obtenerListaTiposCombustible();
		tiposTransmision = unimotorEJB.obtenerListaTransmision();
	}
	
	public void registrarVehiculo() {
		try {
			
			if(!imagenes.isEmpty()) {
			
			
			vehiculo.setPersona(persona);
			
			vehiculo.setFechaPublicacion(new Date());
			vehiculo.setFotos(imagenes);
			unimotorEJB.registrarVehiculo(vehiculo);
			
			
			FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "¡Se ha registrado correctamente el vehiculo!");
			FacesContext.getCurrentInstance().addMessage("registro_vehiculo", msj);
			
			}else {
				FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", "Es necesario agregarle imagenes al vehículo");
				FacesContext.getCurrentInstance().addMessage("registro_vehiculo", msj);
			}
		} catch (Exception e) {
			FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", "¡Se ha registrado correctamente el vehiculo!");
			FacesContext.getCurrentInstance().addMessage("registro_vehiculo", msj);
		}
	}
	
	public void subirImagenes(FileUploadEvent event) {
		UploadedFile imagen = event.getFile();
		 String nombreImagen = subirImagen(imagen);
		 
		 if(nombreImagen!=null) {
			 imagenes.add(nombreImagen);
		 }
	}
	
	public String subirImagen(UploadedFile file) {
		
		try {
			InputStream input = file.getInputStream();
			String filename = FilenameUtils.getName(file.getFileName());
			String basename = FilenameUtils.getBaseName(filename)  + "-";
			String extension = "." + FilenameUtils.getExtension(filename);
			
			File fileDest = File.createTempFile(basename, extension, new File(RUTA_FOTOS));
			FileOutputStream output = new FileOutputStream(fileDest);
			
			IOUtils.copy(input,output);
			
			return  fileDest.getName();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
			
			return null;
		
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

	public List<Ciudad> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}

	public List<Modelo> getModelos() {
		return modelos;
	}

	public void setModelos(List<Modelo> modelos) {
		this.modelos = modelos;
	}

	public List<Caracteristicas> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(List<Caracteristicas> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
    
	
	

}
