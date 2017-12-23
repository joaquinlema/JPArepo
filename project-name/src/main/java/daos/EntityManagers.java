package daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagers {
	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("VaadinPersist");
	
	private EntityManagers()
	{			
	}
	
	public void setUp() throws Exception {
		factory = Persistence.createEntityManagerFactory("VaadinPersist");
	}

	public static void tearDown() throws Exception {
		factory.close();
	}
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
}
