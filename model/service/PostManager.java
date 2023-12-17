package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Post;
import model.dao.PostDAO;

public class PostManager {

    private static PostManager postMan = new PostManager();
    private PostDAO postDAO;
    
    private PostManager() {
        try {
            postDAO = new PostDAO();
            
        } catch (Exception e) {
            e.printStackTrace();
        }           
    }
    
    public static PostManager getInstance() {
        return postMan;
    }
    
    public void create(Post post) throws SQLException {
        try {
            postDAO.createPost(post);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }  
    
    public void remove(int postId) throws SQLException {
        try {
            postDAO.deletePost(postId);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public Post getPost(int postId) throws SQLException {
        Post post = postDAO.getPost(postId);
  
        return post;
    }
    
    public List<Post> getAllPosts() throws SQLException {
    	return postDAO.getAllPosts();
    }
   

    public List<Post> findPostList(String searchString)
        throws SQLException {
            return postDAO.searchPostsByTitle(searchString);
    }
    
    
    public PostDAO getPostDAO() {
        return this.postDAO;
    }

}
