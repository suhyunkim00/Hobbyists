package controller.category;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Category;
import model.service.CategoryManager;

public class ListCategoryController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {

    	CategoryManager manager = CategoryManager.getInstance();
		List<Category> cateList = manager.findCategoryList();

		// commList 객체를 request에 저장하여 커뮤니티 리스트 화면으로 이동(forwarding)
		request.setAttribute("cateList", cateList);
		return "/category/category_list.jsp";
    }
}
