package co.edu.uniquindio.unimotor.dto;

public class ConsultaPerssonasCiudadDTO {

	private String nombrePersona;
	private String email;
	private String direccion;
	
	
	public ConsultaPerssonasCiudadDTO(String nombrePersona, String email, String direccion) {
		super();
		this.nombrePersona = nombrePersona;
		this.email = email;
		this.direccion = direccion;
	}


	public String getNombrePersona() {
		return nombrePersona;
	}


	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	@Override
	public String toString() {
		return "ConsultaPerssonasCiudadDTO [nombrePersona=" + nombrePersona + ", email=" + email + ", direccion="
				+ direccion + "]";
	}
	
	
	
}
