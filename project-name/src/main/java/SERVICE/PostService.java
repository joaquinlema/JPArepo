package SERVICE;

import beans.Post;
import daos.PostDao;

public class PostService {

	private static PostDao postDao;
	
	public PostService(){
		postDao = new PostDao();
	}
	
	public void persist(Post entity){
		
		postDao.persist(entity);
		
	}
}
