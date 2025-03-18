package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserService;
import model.UserVO;

@WebServlet("/mypage.do")
public class MypageController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 			 있으면 mypage.jsp
		String userId = (String) req.getSession().getAttribute("userId");
		if(userId != null) {
			UserService service = UserService.getInstance();
			UserVO vo = service.userInfo(userId);
			req.setAttribute("user", vo);
			req.getRequestDispatcher("/WEB-INF/view/mypage.jsp").forward(req, resp);
		// 세션 체크 후 없으면 login.do 리다이렉트
		} else {
			resp.sendRedirect("login.do");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// id, nm 을 받아서 수정
		// message 전달 mypage.jsp로 리턴이 1이면 수정 되었습니다.
		UserService service = UserService.getInstance();
		UserVO vo = new UserVO();
		vo.setUserId(req.getParameter("userId"));
		vo.setUserPw(req.getParameter("userPw"));
		vo.setUserNm(req.getParameter("userNm"));
		int cnt = service.insertUser(vo);
		// insertUser 리던이 1 이면 login.jsp로 포워드
		if(cnt > 0) {
			req.setAttribute("message", "회원가입이 정상 처리 되었습니다.");
			req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("join.do");
		}
	}
	
}
