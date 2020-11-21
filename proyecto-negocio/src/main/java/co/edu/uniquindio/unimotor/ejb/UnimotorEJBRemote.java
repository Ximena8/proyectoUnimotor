package co.edu.uniquindio.unimotor.ejb;

import java.util.List;

import javax.ejb.Remote;

import co.edu.uniquindio.unimotor.entidades.Caracteristicas;
import co.edu.uniquindio.unimotor.entidades.Ciudad;
import co.edu.uniquindio.unimotor.entidades.Modelo;
import co.edu.uniquindio.unimotor.entidades.Persona;
import co.edu.uniquindio.unimotor.entidades.TipoCombustible;
import co.edu.uniquindio.unimotor.entidades.TipoVehiculo;
import co.edu.uniquindio.unimotor.entidades.Transmision;
import co.edu.uniquindio.unimotor.entidades.Vehiculo;
import co.edu.uniquindio.unimotor.excepcion.VehiculoInexistenteException;

@Remote
public interface UnimotorEJBRemote {
	
	
	void registrarPersona(Persona persona) throws Exception;
	
	Persona iniciarSesion(String email, String clave) throws Exception;
	
	void registrarVehiculo(Vehiculo vehiculo) throws Exception;
	
	List<Vehiculo> obtenerListaVehiculos();

	void modificarVehiculo(Vehiculo vehiculo) throws VehiculoInexistenteException;
	
	void eliminarVehiculo(Vehiculo vehiculo) throws VehiculoInexistenteException;
	
	List<Caracteristicas> obtenerListaCaracteristicas();
	
	List<Ciudad> obtenerListaCidades();
	
	List<Modelo> obtenerListaModelos();
	
	void enviarEmail(String asunto, String mensaje, String destinatario)throws Exception;
	
	Ciudad obtenerCiudad(Integer id);
	
	List<TipoVehiculo>  obtenerListaTiposVehiculos();
	
	List<TipoCombustible> obtenerListaTiposCombustible();
	
	List<Transmision> obtenerListaTransmision();
	
	Persona obtenerPersona(Integer id);
	
	Modelo obtenerModelo(Integer id);
	
	List<Vehiculo> buscarVehiculos(String busqueda);
	
	Caracteristicas obtenerCaracteristica(Integer id);
}
