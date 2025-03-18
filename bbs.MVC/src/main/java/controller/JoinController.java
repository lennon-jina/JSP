package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserService;
import model.UserVO;

@WebServlet("/join.do")
public class JoinController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 화면 이동 join.jsp로
		req.getRequestDispatcher("/WEB-INF/view/join.jsp").forward(req, resp);		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. id, nm을 받아서 수정
		// 2. mypage.jsp로 message 전달 '수정되었습니다'
		UserVO vo = new UserVO();
		vo.setUserId(req.getParameter("userId"));
		vo.setUserNm(req.getParameter("userNm"));
		UserService
		service.updateUser(vo);
		vo = service.userInfo(vo.getUserId());
		
		// 					 아니면 join.do로 리다이렉트
		} else {
			resp.sendRedirect("join.do");
		}
	}
}
