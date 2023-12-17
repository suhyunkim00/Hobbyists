package controller.category;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Category;
import model.Community;
import model.service.CategoryManager;
import model.service.UserManager;

public class UpdateCategoryController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(UpdateCategoryController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {

		int cateId = Integer.parseInt(request.getParameter("id"));

		if (request.getMethod().equals("GET")) {
    		// GET request: 커뮤니티 수정 form 요청
    		CategoryManager manager = CategoryManager.getInstance();
			Category cate = manager.findCategory(cateId);	// 수정하려는 커뮤니티 정보 검색
			request.setAttribute("category", cate);

			List<Category> members = manager.findCommunityMembers(commId); // 커뮤니티 회원 리스트 검색
			request.setAttribute("members", members);
			return "/community/updateForm.jsp";   // 검색한 정보를 update form으로 전송
	    }

    	// POST request (커뮤니티 정보가 parameter로 전송됨)
    	Community comm = new Community(
    		commId,
    		request.getParameter("name"),
    		request.getParameter("desc"),
    		null, request.getParameter("chairId"), null);

    	log.debug("Update Community : {}", comm);

		UserManager manager = UserManager.getInstance();
		manager.updateCommunity(comm);
        return "redirect:/community/list";
    }
}
