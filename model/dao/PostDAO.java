package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import model.User;
import model.Post;

public class PostDAO {
    private JDBCUtil jdbcUtil;

    public PostDAO() {
        jdbcUtil = new JDBCUtil();
    }

    
    public List<Post> getAllPosts() {
        String sql = "SELECT * FROM post";
        return executeQueryAndMapPosts(sql, null);
    }
    
    public Post getPost(int postId) {
        String sql = "SELECT * FROM post WHERE post_id = ?";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {postId});   // JDBCUtil에 query문과 매개 변수 설정
    
        try {
            ResultSet resultSet = jdbcUtil.executeQuery();     // query 실행
            if (resultSet.next()) {         // User 객체를 생성하여 학생 정보를 저장
                Post post = new Post();
                post.setId(resultSet.getInt("post_id"));
                post.setTitle(resultSet.getString("post_title"));
                post.setContent(resultSet.getString("post_content"));

                System.out.println(post);
                
                return post;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();       // resource 반환
        }
        return null;
    }
    

    public List<Post> searchPostsByTitle(String searchString) {
        String sql = "SELECT * FROM POST WHERE title LIKE ?";
        return executeQueryAndMapPosts(sql, new Object[]{"%" + searchString + "%"});
    }

    public void createPost(Post post) throws Exception {
        String sql = "INSERT INTO POST (post_ID, post_title, post_content, user_id) VALUES (post_id_sequence.NEXTVAL, ?, ?, ?, ?)";
        //executeUpdateWithPost(sql, post);
    }

    public void deletePost(int postId) throws Exception {
        String sql = "DELETE FROM POST WHERE id = ?";
        jdbcUtil.setSqlAndParameters(sql, new Object[]{postId});
        //executeUpdate();
    }

    private List<Post> executeQueryAndMapPosts(String sql, Object[] params) {
        List<Post> posts = new ArrayList<>();
        jdbcUtil.setSqlAndParameters(sql, params);

        try {
            ResultSet resultSet = jdbcUtil.executeQuery();

            while (resultSet.next()) {
                Post post = mapResultSetToPost(resultSet);
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close();
        }

        return posts;
    }

    private Post mapResultSetToPost(ResultSet resultSet) throws SQLException {
        Post post = new Post();
        post.setId(resultSet.getInt("post_ID"));
        post.setTitle(resultSet.getString("post_title"));
        post.setContent(resultSet.getString("post_content"));

        return post;
    }

    private User getUserById(String userId) {
        String sql = "SELECT * FROM users WHERE id = ?";
        jdbcUtil.setSqlAndParameters(sql, new Object[]{userId});

        try {
            ResultSet resultSet = jdbcUtil.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToUser(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    //DB결과 User객체로
    private User mapResultSetToUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setUserId(resultSet.getString("user_id"));
        user.setName(resultSet.getString("user_name"));
        return user;
    }
}
