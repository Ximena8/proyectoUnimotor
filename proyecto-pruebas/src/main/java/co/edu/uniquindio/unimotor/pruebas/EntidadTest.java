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

/*
 * LISTO, HABÍA MUCHOS ERRORES PERO CREO QUE ERA PORQUE SE ESTABAN HACIENDO MAL
 * LAS VALIDACIONES EN ESTA CLASE DE TEST. PERO LISTO. muchas gracias profe
 */

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
	public void test() {

	}


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

		//si está actualizando el registro 2, entonces acá se debe comprobar que sí actualizó
		Caracteristicas cBuscada= entityManager.find(Caracteristicas.class, 2);
		Assert.assertEquals("Sistema Integrado de navegación", cBuscada.getNombre());

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

		Ciudad c = entityManager.find(Ciudad.class, 4);// la 4 es Cartagena
		Assert.assertEquals("Cartagena", c.getNombre());

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
		//es es el nombre del modelo 5
		Assert.assertEquals("SPARK GT", m.getNombre());

	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void actualizarModeloTest() throws ParseException{

		//si acá actualiza al modelo 3
		Modelo m = entityManager.find(Modelo.class,3 );
		m.setNombre("Duster");
		entityManager.merge(m);

		//acá debe volver a buscar ese mismo modelo para verificar que si se actualizó
		Modelo mBusacado= entityManager.find(Modelo.class, 3);
		Assert.assertEquals("Duster", mBusacado.getNombre());

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
		Assert.assertNotNull( p);

	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void actualizarPreguntaTest() throws ParseException{

		//acá igual, todos los métodos de actualizar estan malos porque actualiza una registro y debe comprobar ese mismo

		Pregunta p = entityManager.find(Pregunta.class, 1);
		p.setPregunta("En que horario puedo ver el vehiculo");
		entityManager.merge(p);

		Pregunta pBusacada = entityManager.find(Pregunta.class, 1);
		Assert.assertEquals("En que horario puedo ver el vehiculo", pBusacada.getPregunta());

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

		Persona p = entityManager.find(Persona.class, 4);
		//maria@email.com pertecene es a la persona 4, NO a la 5
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
	@UsingDataSet({"unimotor.json"})
	public void buscarVehiculoTest() {
		Vehiculo v = entityManager.find(Vehiculo.class, 1);
		Assert.assertNotNull(v);
	}


	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void eliminarVehiculoTest() throws ParseException{

		Vehiculo v = entityManager.find(Vehiculo.class, 2);
		entityManager.remove(v);

		//Si arriba está eliminando un vehículo, por qué acá abajo busca una Persona?
		//Persona vehiculoBusacado = entityManager.find(Persona.class,2);
		//Assert.assertNull( vehiculoBusacado);

		Vehiculo v2 = entityManager.find(Vehiculo.class, 2);
		Assert.assertNull( v2 );

	}


}
