package controller.post;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Post;
import model.User;
import model.service.PostManager;
import model.service.UserManager;

public class AddPostController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(AddPostController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
    	Post post = new Post();
    	PostManager manager = PostManager.getInstance();

		String title = request.getParameter("title");  
		String content = request.getParameter("content");
		//User creator = request.getParameter("creator");

		post.setTitle(title);
		post.setContent(content);
		//post.setCreator(creator);
    	
		try {
			manager.create(post);
		}catch(Exception e) {
			return "redirect:/post/PostList";
		}
        request.setAttribute("post", post);            
        return "/myPage/myPage.jsp";  
    }
}
