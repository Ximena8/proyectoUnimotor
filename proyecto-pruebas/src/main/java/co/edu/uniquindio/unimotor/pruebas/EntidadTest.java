package co.edu.uniquindio.unimotor.pruebas;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

import com.hazelcast.internal.json.ParseException;

import co.edu.uniquindio.unimotor.entidades.Caracteristicas;
import co.edu.uniquindio.unimotor.entidades.Ciudad;
import co.edu.uniquindio.unimotor.entidades.Favorito;
import co.edu.uniquindio.unimotor.entidades.Marca;
import co.edu.uniquindio.unimotor.entidades.Modelo;
import co.edu.uniquindio.unimotor.entidades.Persona;
import co.edu.uniquindio.unimotor.entidades.Pregunta;
import co.edu.uniquindio.unimotor.entidades.Vehiculo;

@RunWith(Arquillian.class)
public class EntidadTest {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap.create(WebArchive.class,

				"prueba.war").addPackage(Persona.class.getPackage())
				.addAsResource("persistenceForTest.xml",

						"META-INF/persistence.xml")

				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

	}
// Pruebas unitarias



	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void buscarCaracteristicaTest() {
		
		Caracteristicas c= entityManager.find(Caracteristicas.class, 1);
		Assert.assertEquals("GPS", c.getNombre());
		
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void actualizarCaracteristicaTest() throws ParseException{
		
		Caracteristicas c = entityManager.find(Caracteristicas.class, 2);
		c.setNombre("Sistema Integrado de navegación");
		entityManager.merge(c);
		
		Caracteristicas cBuscada= entityManager.find(Caracteristicas.class, 3);
		Assert.assertEquals("Asientos de piel", cBuscada.getNombre());
		
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void eliminarCaracteristicaTest() throws ParseException{
		
		Caracteristicas c = entityManager.find(Caracteristicas.class, 5);
		entityManager.remove(c);
		
		Caracteristicas cBusacada = entityManager.find(Caracteristicas.class,5);
		Assert.assertNull( cBusacada);
		
	}
	
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void buscarCiudadTest() {
		
		Ciudad c = entityManager.find(Ciudad.class, 4);
		Assert.assertEquals("Calí", c.getNombre());
		
	}
	
	
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void actualizarCiudadTest() throws ParseException{
		
		Ciudad c = entityManager.find(Ciudad.class, 3);
		c.setNombre("Pereira");
		entityManager.merge(c);
		
		Ciudad cBusacada = entityManager.find(Ciudad.class, 6);
		Assert.assertEquals("Bogota", cBusacada.getNombre());
		
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void eliminarCiudadTest() throws ParseException{
		
		Ciudad c = entityManager.find(Ciudad.class, 2);
		entityManager.remove(c);
		
		Ciudad cBusacada = entityManager.find(Ciudad.class,2);
		Assert.assertNull( cBusacada);
		
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void buscarMarcaTest() {
		
		Marca m= entityManager.find(Marca.class, 5);
		Assert.assertEquals("CHEVROLET", m.getNombre());
		
	}
	

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void actualizarMarcaTest() throws ParseException{
		
		Marca m = entityManager.find(Marca.class, 1);
		m.setNombre("BMW");
		entityManager.merge(m);
		
		Marca mBusacada = entityManager.find(Marca.class, 4);
		Assert.assertEquals("RENAULT", mBusacada.getNombre());
		
	}
	

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void eliminarMarcaTest() throws ParseException{
		
		Marca m = entityManager.find(Marca.class, 2);
		entityManager.remove(m);
		
		Marca mBusacada = entityManager.find(Marca.class,2);
		Assert.assertNull( mBusacada);
		
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void buscarModeloTest() {
		
		Modelo m = entityManager.find(Modelo.class, 5);
		Assert.assertEquals("Kia Optima Hibrido", m.getNombre());
		
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void actualizarModeloTest() throws ParseException{
		
		Modelo m = entityManager.find(Modelo.class,3 );
		m.setNombre("Duster");
		entityManager.merge(m);
		
		Modelo mBusacado= entityManager.find(Modelo.class, 2);
		Assert.assertEquals("Mazda2", mBusacado.getNombre());
		
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void eliminarModeloTest() throws ParseException{
		
		Modelo m = entityManager.find(Modelo.class, 1);
		entityManager.remove(m);
		
		Modelo mBusacado = entityManager.find(Modelo.class,1);
		Assert.assertNull(mBusacado);
		
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void buscarPreguntaTest() {
		
		Pregunta p = entityManager.find(Pregunta.class, 5);
		Assert.assertEquals("En que horario puedo ver el vehiculo", p.getPregunta());
		
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void actualizarPreguntaTest() throws ParseException{
		
		Pregunta p = entityManager.find(Pregunta.class, 1);
		p.setPregunta("En que horario puedo ver el vehiculo");
		entityManager.merge(p);
		
		Pregunta pBusacada = entityManager.find(Pregunta.class, 3);
		Assert.assertEquals("El carro tiene todos los documentos al día ?", pBusacada.getPregunta());
		
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void eliminarPreguntaTest() throws ParseException{
		
		Pregunta p = entityManager.find(Pregunta.class, 5);
		entityManager.remove(p);
		
		Pregunta pBusacada = entityManager.find(Pregunta.class,5);
		Assert.assertNull( pBusacada);
		
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void buscarPersonaTest() {
		
		Persona p = entityManager.find(Persona.class, 5);
		Assert.assertEquals("maria@email.com", p.getEmail());
		
	}
	
	
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void actualizarPersonaTest() throws ParseException{
		
		Persona p = entityManager.find(Persona.class, 4);
		p.setEmail("maria@gmail.com");
		entityManager.merge(p);
		
		Persona pBusacada = entityManager.find(Persona.class, 4);
		Assert.assertEquals("maria@gmail.com", pBusacada.getEmail());
		
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void eliminarPersonaTest() throws ParseException{
		
		Persona p = entityManager.find(Persona.class, 2);
		entityManager.remove(p);
		
		Persona pBusacada = entityManager.find(Persona.class,2);
		Assert.assertNull( pBusacada);
		
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json","unimotor.json"})
	public void buscarVehiculoTest() {
		
	Vehiculo v = entityManager.find(Vehiculo.class, 1);
		System.out.println(v);
		
	}
	
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void eliminarVehiculoTest() throws ParseException{
		
		Vehiculo v = entityManager.find(Vehiculo.class, 2);
		entityManager.remove(v);
		
		Persona vehiculoBusacado = entityManager.find(Persona.class,2);
		Assert.assertNull( vehiculoBusacado);
		
	}
	

}
