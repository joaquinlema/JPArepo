package org.hibernate.tutorial.em.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.hibernate.tutorial.em.A;
import org.hibernate.tutorial.em.B;
import org.hibernate.tutorial.em.ClienteEjemplo;
import org.hibernate.tutorial.em.Direccion;
import org.hibernate.tutorial.em.ct2ejercicios.Cliente;
import org.hibernate.tutorial.em.ct2ejercicios.Departamento;
import org.hibernate.tutorial.em.ct2ejercicios.Empleado;
import org.hibernate.tutorial.em.ct2ejercicios.Proyecto;
import org.hibernate.tutorial.em.ct2ejercicios.ProyectoLocal;
import org.hibernate.tutorial.em.ct2ejercicios.Unidad_de_Negocio;
import org.hibernate.tutorial.em.ct4ejercicios.D;
import org.hibernate.tutorial.em.ct4ejercicios.E;
import org.hibernate.tutorial.em.ct4ejercicios.F;
import org.hibernate.tutorial.em.ejemplos.Agencia;
import org.hibernate.tutorial.em.ejemplos.Auto;
import org.hibernate.tutorial.em.ejemplos.Jefe;
import org.hibernate.tutorial.em.ejemplos.Libro;
import org.hibernate.tutorial.em.ejemplos.Pais;
import org.hibernate.tutorial.em.ejemplos.Peon;
import org.hibernate.tutorial.em.ejemplos.Persona;
import org.hibernate.tutorial.em.ejemplos.Presidente;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;


public class EntityManagerTest {
	private static EntityManagerFactory entityManagerFactory;

	@BeforeClass
	public static void setUp() throws Exception {
			entityManagerFactory = Persistence.createEntityManagerFactory( "org.hibernate.tutorial.jpa" );
	}

	@AfterClass
	public static void tearDown() throws Exception {
		entityManagerFactory.close();
	}

	
	@Test
	public void testHibernate() {
		// Creamos un cliente con su dirección
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		ClienteEjemplo c = new ClienteEjemplo(2003581, "Cliente1");
		c.setDir(new Direccion("Domicilio1"));
	
		entityManager.persist(c);
		entityManager.getTransaction().commit();
		entityManager.close();

		//y los recuperamos.
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
        List<ClienteEjemplo> result = entityManager.createQuery( "from ClienteEjemplo", ClienteEjemplo.class ).getResultList();
		for ( ClienteEjemplo cliente : result ) {
			System.out.println( cliente.getRazonSocial() + " " + cliente.getDir().getDomicilio());
		}
        entityManager.getTransaction().commit();
        entityManager.close();
	}
	
	@Test
	public void testhibernateEjercitacion1(){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		A c = new A();
		c.setA1("joaquinCap");
		B b = new B();
		b.setB1("camelCase");
		b.setB2("marlboroCase");
		b.addAssss(c);
		c.setB(b);
	
		entityManager.persist(c);
		entityManager.getTransaction().commit();
		entityManager.close();
	
	}
	
	@Test
	public void testhibernateMergeEjercitacion3(){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		A a = new A();
		a.setA1("joaquinCap");
		
		B b = new B();
		b.setB1("camelCase");
		b.setB2("marlboroCase");
		b.addAssss(a);
		a.setB(b);
	
		entityManager.persist(a);
		entityManager.getTransaction().commit();
		entityManager.close();
	
		EntityManager entityManager2 = entityManagerFactory.createEntityManager();
		entityManager2.getTransaction().begin();
		
		a = entityManager2.merge(a);
		b.removeAsss(a);
		
		entityManager2.persist(a);
		entityManager2.getTransaction().commit();
		entityManager2.close();
	
	}
	
	@Test
	public void testhibernateQueryEjercitacion3(){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		A a = new A();
		a.setA1("joaquinCap22");
		
		entityManager.persist(a);
		entityManager.getTransaction().commit();
		
		TypedQuery<A> query = entityManager.createQuery("SELECT a FROM A a", A.class);
		List<A> resultado = query.getResultList();
		
		System.out.println(resultado.get(0).getA1());
		entityManager.close();
	
	}

	@Test
	public void testOnetoOneUnidireccional(){
		EntityManager manager = entityManagerFactory.createEntityManager();
		manager.getTransaction().begin();
		
		Auto auto = new Auto("Chevrolet");
		
		Agencia agencia = new Agencia("Automoviles uno");
		
		agencia.setAuto(auto);
		
		manager.persist(agencia);
		manager.getTransaction().commit();
		manager.close();
	}

	@Test
	public void testOnetoOneBidireccional(){
		EntityManager manager = entityManagerFactory.createEntityManager();
		manager.getTransaction().begin();
		
		Presidente p = new Presidente("Peron peron");
		Pais pais = new Pais("Argentina");
		
		p.setPais(pais);
		pais.setPresidente(p);
		
		
		manager.persist(pais);
		manager.getTransaction().commit();
		manager.close();
	}
	
	@Test
	public void testOnetoManyUnidireccional(){
		EntityManager eme = entityManagerFactory.createEntityManager();
		eme.getTransaction().begin();
		
		Persona people = new Persona("Ernesto Sabato");
		
		Libro lib = new Libro("obras varias");
		Libro lib2 = new Libro("El tunel");
		Libro lib3 = new Libro("antes del fin");
		Libro lib4 = new Libro("uno y el universo");
		
		people.addLibro(lib);
		people.addLibro(lib2);
		people.addLibro(lib3);
		people.addLibro(lib4);
		
		eme.persist(people);
		eme.getTransaction().commit();
		eme.close();
	}
	
	@Test
	public void testOnetoManyBidireccional(){
		EntityManager eme = entityManagerFactory.createEntityManager();
		eme.getTransaction().begin();
		
		Jefe jefecito = new Jefe("Mi Jefe");
		Jefe jefecitORRHH = new Jefe("Mi Jefe RRHH");
		Jefe jefecitoQA = new Jefe("Mi Jefe QA");
		
		Peon emp1 = new Peon("Empleado 1");
		Peon emp2 = new Peon("Empleado 2");
		Peon emp3 = new Peon("Empleado 3");
		Peon emp4 = new Peon("Empleado 4");
		Peon emp5 = new Peon("Empleado 5");
		Peon emp6 = new Peon("Empleado 6");
		
		jefecito.addEmpleado(emp1);
		jefecitoQA.addEmpleado(emp2);
		jefecitoQA.addEmpleado(emp3);
		jefecitoQA.addEmpleado(emp4);
		jefecitORRHH.addEmpleado(emp5);
		jefecitORRHH.addEmpleado(emp6);
		
		eme.persist(jefecitoQA);
		eme.persist(jefecitORRHH);
		eme.persist(jefecito);
		eme.getTransaction().commit();
		eme.close();
	}

	@Test
	public void testProyectoCliente(){
		EntityManager manage = entityManagerFactory.createEntityManager();
		manage.getTransaction().begin();
		
		Proyecto p1 = new Proyecto("Proyecto integrador", "22/01/2019");
		
		Cliente cliente = new Cliente("29-9987665-2", "Jose Perez");
		
		p1.setCliente(cliente);
		
		manage.persist(p1);
		manage.getTransaction().commit();
		manage.close();
	}
	
	@Test
	public void testClienteProyectoFind(){
		EntityManager manage = entityManagerFactory.createEntityManager();
		manage.getTransaction().begin();
		
		Proyecto p = new ProyectoLocal("ProyectoLocal 1", "12/01/2019", "Buenos Aires", 100);
		
		Cliente cliente = new Cliente("29-9987665-2", "Jose Perez");
		Cliente cliente1 = new Cliente("29-991235-2", "Jose Juarez");
		Cliente cliente2 = new Cliente("29-435465-2", "Jose Gonzalez");
		Cliente cliente3 = new Cliente("29-934545-2", "Juna Lopez");
		
		p.setCliente(cliente);
		p.setCliente(cliente1);
		p.setCliente(cliente2);
		p.setCliente(cliente3);
		
		manage.persist(p);
		manage.getTransaction().commit();
		manage.close();
		
		EntityManager manage2 = entityManagerFactory.createEntityManager();
		manage2.getTransaction().begin();
		
		long id = 1;
		
		Proyecto p1 = manage2.find(Proyecto.class,id);
		
		System.out.println(p1.getNombre() + " " + p1.getCliente().getNombre() + " " + p1.getCliente().getCuit());
		
		manage2.close();
	}
	
	@Test
	public void testClienteProyecto(){
		EntityManager manage = entityManagerFactory.createEntityManager();
		manage.getTransaction().begin();
		
		Proyecto p1 = new Proyecto("Proyecto integrador", "22/01/2019");
		
		Cliente cliente = new Cliente("29-9987665-2", "Jose Perez");
		
		p1.setCliente(cliente);
		
		manage.persist(cliente);
		manage.getTransaction().commit();
		manage.close();
	}
	
	@Test
	public void testPersistirUnidad(){
		EntityManager manage = entityManagerFactory.createEntityManager();
		manage.getTransaction().begin();
		
		Empleado emp = new Empleado(123321, "Jorge Paez");
		Departamento depto = new Departamento("5546", "Sistemas");
		Unidad_de_Negocio uNeg = new Unidad_de_Negocio("6455", "Negocio unidad");
		
		depto.addEmpleados(emp);
		uNeg.addDepartamento(depto);
		
		manage.persist(uNeg);
		manage.getTransaction().commit();
		manage.close();
	}
	
	@Ignore
	@Test
	public void testPersistirEmpleado(){
		EntityManager manage = entityManagerFactory.createEntityManager();
		manage.getTransaction().begin();
		
		Empleado emp = new Empleado(123321, "Test Paez");
		Departamento depto = new Departamento("5546", "Depto Test");
		Unidad_de_Negocio uNeg = new Unidad_de_Negocio("6455", "Negocio unidad");
		
		depto.addEmpleados(emp);
		uNeg.addDepartamento(depto);
		
		manage.persist(emp);
		manage.getTransaction().commit();
		manage.close();
	}
	
	@Test
	public void testBorrarUnidad(){
		EntityManager manage = entityManagerFactory.createEntityManager();
		manage.getTransaction().begin();
		
		Empleado emp = new Empleado(122421, "Jorge Paez Gimenez");
		Departamento depto = new Departamento("5546", "Base de datos");
		Unidad_de_Negocio uNeg = new Unidad_de_Negocio("64355", "Negocio unidad");
		
		depto.addEmpleados(emp);
		uNeg.addDepartamento(depto);
		
		manage.persist(uNeg);
		manage.getTransaction().commit();
		manage.close();
		
		EntityManager managerSegundo = entityManagerFactory.createEntityManager();
		managerSegundo.getTransaction().begin();
		
		long id = 1;
		
		Unidad_de_Negocio u1 = managerSegundo.find(Unidad_de_Negocio.class, id);
		managerSegundo.remove(u1);
		
		managerSegundo.getTransaction().commit();
		managerSegundo.close();
	}
	
	@Test
	public void testDEF(){
		EntityManager manage = entityManagerFactory.createEntityManager();
		manage.getTransaction().begin();
		
		D d = new D();
		E e = new E();
		F f = new F();
		
		e.addDs(d);
		e.addFs(f);
		
		manage.persist(e);
		manage.getTransaction().commit();
		manage.close();	
		
	}

}
