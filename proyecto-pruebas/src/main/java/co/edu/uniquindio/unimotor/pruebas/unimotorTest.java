package co.edu.uniquindio.unimotor.pruebas;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.uniquindio.unimotor.dto.ConsultaPerssonasCiudadDTO;
import co.edu.uniquindio.unimotor.entidades.Persona;
import co.edu.uniquindio.unimotor.entidades.Transmision;
import co.edu.uniquindio.unimotor.entidades.Vehiculo;

@RunWith(Arquillian.class)
public class unimotorTest {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap.create(WebArchive.class,

				"prueba.war").addPackage(Vehiculo.class.getPackage())
				.addAsResource("persistenceForTest.xml",

						"META-INF/persistence.xml")

				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

	}

	@Test
	public void test() {

  
	}
	
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void testLista() {
		
		TypedQuery <Vehiculo>q = entityManager.createNamedQuery("TODOS_VEHICULO", Vehiculo.class);
		List <Vehiculo> l = q.getResultList();
		
		for(Vehiculo v : l) {
			
			System.out.println(v.getDescripcion() + " " +v.getPrecio());
			
		}
	}
	
	
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void testListaVehiculoTransmision() {
		
		TypedQuery <Vehiculo>q = entityManager.createNamedQuery("TODOS_VEHICULOS_TRANSMISION", Vehiculo.class);
		q.setParameter("tran", Transmision.AUTOMATICO);
		
		List <Vehiculo> l = q.getResultList();
		
		for(Vehiculo v : l) {
			
			System.out.println(v.getDescripcion() + " " +v.getPrecio());
			
		}
	}
	
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void testAutenticacion() {
		
		TypedQuery <Persona>q = entityManager.createNamedQuery("AUTENTICAR_PERSONA", Persona.class);
		q.setParameter("email", "ximena@email.com");
		q.setParameter("clave", "321");
		
		List <Persona> l = q.getResultList();
		
	   Assert.assertEquals(1, l.size());
		
		
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void listaVehiculosTest() {
		
		TypedQuery <Vehiculo>q = entityManager.createNamedQuery("TODOS_VEHICULO", Vehiculo.class);
		q.setMaxResults(3);
		q.setFirstResult(2);
		List<Vehiculo> l = q.getResultList();
		
	 for(Vehiculo vehiculo : l ) {
		 
		 System.out.println(vehiculo);
	 }
		
		
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void vehiculoDescripcioTest() {
		
		//devuelve arreglo de objetos en una cpnsulta
		TypedQuery <Object[]> q = entityManager.createNamedQuery("VEHICULO_DESCRIPCION", Object[].class);
		              
		   q.setParameter("descrip","Moto en exceltes condiciones, sin seguro");
		
				List<Object[]> l = q.getResultList();
		
	 for( Object[] vehiculo : l ) {
		 
		 System.out.println(vehiculo[0]+" "+vehiculo[1]+" "+vehiculo[2]);
	 }
  
	}
	
	
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void listaVehiculosFavoritosTest() {
		
		TypedQuery <Vehiculo>q = entityManager.createNamedQuery("LISTA_FAVORITOS_PERSONA", Vehiculo.class);
		q.setParameter("email", "ximena@email.com");
		List<Vehiculo> l = q.getResultList();
		
	 for(Vehiculo vehiculo : l ) {
		 
		 System.out.println(vehiculo);
	 }
		
		
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void listaVehiculosFavoritos2Test() {
		
		TypedQuery <Object[]>q = entityManager.createNamedQuery("LISTA_FAVORITOS_JOIN", Object[].class);
		q.setParameter("email", "ximena@email.com");
		List<Object[]> l = q.getResultList();
		
	 for(Object[] vehiculo : l ) {
		 
		 System.out.println(vehiculo[0]+" "+vehiculo[1]);
	 }
		
		
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void listaPersonaVehiculoTest() {
		
		TypedQuery <Object[]>q = entityManager.createNamedQuery("LISTA_VEHICULOS_VENTA", Object[].class);
		
		List<Object[]> l = q.getResultList();
		
	 for(Object[] vehiculo : l ) {
		 
		 System.out.println(vehiculo[0]+"---"+vehiculo[1]);
	 }
		
		
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void listaPreguntasVehiculoTest() {
		
		TypedQuery <Object[]>q = entityManager.createNamedQuery("LISTA_PREGUNTAS_VEHICULO", Object[].class);
		
		List<Object[]> l = q.getResultList();
		
	 for(Object[] vehiculo : l ) {
		 
		 System.out.println(vehiculo[0]+"---"+vehiculo[1]);
	 }
		
		
	}
	
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void listaPersonasDistintasTest() {
		
		TypedQuery <Persona>q = entityManager.createNamedQuery("LISTA_PERSONAS_PREGUNTA_VEHICULO", Persona.class);
		
		List<Persona> l = q.getResultList();
		
	 for(Persona p : l ) {
		 
		 System.out.println(p);
	 }
		
		
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void listaFotosVehiculoTest() {
		
		TypedQuery <Vehiculo>q = entityManager.createNamedQuery("LISTA_FOTOS_VEHICULO", Vehiculo.class);
		q.setParameter("marca","");
		q.setParameter("precioMax","");
		q.setParameter("precioMin","");
		
		List<Vehiculo> l = q.getResultList();
		
	 for(Vehiculo vehiculo : l ) {
		 
		 System.out.println(vehiculo);
	 }
		
		
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void listaPersonasCiudadTest() {
		
		TypedQuery <ConsultaPerssonasCiudadDTO>q = entityManager.createNamedQuery("LISTA_CIUDAD_PERSONAS", ConsultaPerssonasCiudadDTO.class);
		q.setParameter("nombre","Medellin");
		
		
		List<ConsultaPerssonasCiudadDTO> l = q.getResultList();
		
	 for(ConsultaPerssonasCiudadDTO cpc : l ) {
		 
		 System.out.println(cpc);
	 }
		
		
	}
	
}

