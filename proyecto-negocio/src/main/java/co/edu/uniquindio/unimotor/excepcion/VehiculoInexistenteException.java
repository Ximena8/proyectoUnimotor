package co.edu.uniquindio.unimotor.excepcion;

public class VehiculoInexistenteException extends Exception{

	private static final long serialVersionUID = 1L;


	public VehiculoInexistenteException(String mensaje) {
		super(mensaje);
	}
}
