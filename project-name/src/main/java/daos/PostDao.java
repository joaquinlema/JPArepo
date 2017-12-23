package daos;

import java.util.List;

import javax.persistence.EntityManager;


import beans.Post;

public class PostDao implements Dao<Post, String> {
	
	private EntityManager manager;
	
	public EntityManager getEntityManager() {
		return EntityManagers.getEntityManager();
	}
	
	public void persist(Post entity) {
		manager = getEntityManager();
		manager.persist(entity);
		manager.getTransaction().commit();
		manager.close();
	}

	@Override
	public void update(Post entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Post findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Post entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Post> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	
}
