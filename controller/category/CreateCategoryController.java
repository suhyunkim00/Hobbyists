package controller.category;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Category;
import model.service.CategoryManager;

public class CreateCategoryController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(CreateCategoryController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Category cate = new Category(
    		0, request.getParameter("name"));

		try {
			CategoryManager manager = CategoryManager.getInstance();
			manager.create(cate);

	    	log.debug("Create Category : {}", cate);
	        return "redirect:/community/list";	// 성공 시 커뮤니티 리스트 화면으로 redirect

		} catch (Exception e) {		// 예외 발생 시 입력 form으로 forwarding
            request.setAttribute("creationFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("ate", cate);
			return "/category/creationForm.jsp";
		}
    }
}
