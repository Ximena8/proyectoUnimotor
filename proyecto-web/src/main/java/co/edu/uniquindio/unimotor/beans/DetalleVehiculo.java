package co.edu.uniquindio.unimotor.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.annotation.ManagedProperty;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotBlank;

import co.edu.uniquindio.unimotor.ejb.UnimotorEJB;
import co.edu.uniquindio.unimotor.entidades.Caracteristicas;
import co.edu.uniquindio.unimotor.entidades.Persona;
import co.edu.uniquindio.unimotor.entidades.Pregunta;
import co.edu.uniquindio.unimotor.entidades.Vehiculo;

@Named
@ViewScoped
public class DetalleVehiculo implements Serializable {
	
	@EJB
	private UnimotorEJB unimotorEJB;
	private static final long serialVersionUID = 1L;
	private Vehiculo vehiculo;
	@NotBlank
	private String pregunta;
	private boolean favorito;
	
	@Inject
	@ManagedProperty(value = "#{param.vehiculo}")
	private  String proyectoParam;
	
	private List<Pregunta> preguntas;
	private List<Caracteristicas> Caracteristica;
	
	private Persona persona;
	
	@PostConstruct
	public void inicializar() {
		if(proyectoParam!=null && !proyectoParam.isEmpty()) {
			
			try {
				
				int codigoV = Integer.parseInt(proyectoParam);
				
				vehiculo = unimotorEJB.obtenerVediculo(codigoV);
				preguntas = unimotorEJB.obtenerPreguntasVehiculo(codigoV);
				Caracteristica = unimotorEJB.obtenerCaracteristicasVehiculo(codigoV);
				
			}catch(Exception e ){
				e.printStackTrace();
			
			}
			
		}
		
	}
	
	public void hacerPregunta() {
		try {
		Pregunta p = unimotorEJB.hacerPregunta(persona,vehiculo,pregunta);
		if(p!=null) {
			preguntas.add(p);	
		     }
		}catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Alerta", e.getMessage());
			FacesContext.getCurrentInstance().addMessage("msj-pregunta", m);
		}	
		
	}
	public void marcarComoFavorito() {
		if(favorito) {
			unimotorEJB.guardarFavorito(persona, vehiculo);
		}else {
			unimotorEJB.eliminarFavorito(persona, vehiculo);
		}
	}

	public UnimotorEJB getUnimotorEJB() {
		return unimotorEJB;
	}

	public void setUnimotorEJB(UnimotorEJB unimotorEJB) {
		this.unimotorEJB = unimotorEJB;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public boolean isFavorito() {
		return favorito;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}

	public String getProyectoParam() {
		return proyectoParam;
	}

	public void setProyectoParam(String proyectoParam) {
		this.proyectoParam = proyectoParam;
	}

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public List<Caracteristicas> getCaracteristica() {
		return Caracteristica;
	}

	public void setCaracteristica(List<Caracteristicas> caracteristica) {
		Caracteristica = caracteristica;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	

}
