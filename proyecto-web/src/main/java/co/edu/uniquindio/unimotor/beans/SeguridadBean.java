package co.edu.uniquindio.unimotor.beans;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import co.edu.uniquindio.unimotor.ejb.UnimotorEJB;
import co.edu.uniquindio.unimotor.entidades.Persona;

@Named
@SessionScoped
public class SeguridadBean implements Serializable{

	@EJB
	private UnimotorEJB unimotorEJB;
	private static final long serialVersionUID = 1L;
	
	private Persona persona;
	private boolean autenticado;
	
	@NotBlank
	@Email
	private String emailLogin;
	
	@NotBlank
	private String passwordLogin;
	
	
	
	@PostConstruct
	public void inicializar() {
		autenticado = false;
		persona = new Persona();
	}
	
	public String autenticarUsuario() {
		try {
			Persona p = unimotorEJB.iniciarSesion(emailLogin, passwordLogin);
			
			if(p!=null) {
				autenticado = true;
				persona=p;
				
				return"/index?faces-redirect=true";
			}
			
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Alerta", e.getMessage());
			FacesContext.getCurrentInstance().addMessage("mensaje_sesion", m);
		}
		
		return null;
	}
	
	public  void enviarCorreo() {
		
	}
	
	public String cerrarSesion() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/index?faces-redirect=true";
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public boolean isAutenticado() {
		return autenticado;
	}

	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}

	public String getEmailLogin() {
		return emailLogin;
	}

	public void setEmailLogin(String emailLogin) {
		this.emailLogin = emailLogin;
	}

	public String getPasswordLogin() {
		return passwordLogin;
	}

	public void setPasswordLogin(String passwordLogin) {
		this.passwordLogin = passwordLogin;
	}
	
	
	
	

}
