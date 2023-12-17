package controller.category;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Category;
import model.service.CategoryManager;

public class ViewCategoryController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	Category cate = null;
		CategoryManager manager = CategoryManager.getInstance();
		int cateId = Integer.parseInt(request.getParameter("cateId"));
		cate = manager.findCategory(cateId);		// 커뮤니티 정보 검색

		request.setAttribute("category", cate);	// 커뮤니티 정보 저장
		return "/category/category_detail.jsp";				// 커뮤니티 보기 화면으로 이동
    }
}
