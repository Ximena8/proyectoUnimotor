package co.edu.uniquindio.unimotor.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class HolaMundoBean {

	private String mensaje = "Hola desde el managed bean";

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	
}
