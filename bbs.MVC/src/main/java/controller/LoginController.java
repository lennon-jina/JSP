package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserService;
import model.UserVO;

@WebServlet({"/login.do", "/logout.do"})
public class LoginController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청 경로
		String pathString = req.getServletPath();
		if("/login.do".equals(pathString)) {
			String userId= (String) req.getSession().getAttribute("userId");
			// 로그인 정보가 있으면
			if(userId != null) {
				resp.sendRedirect("index.do");
			} else {
			// forward 데이터와 함께 전달
			req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
			}
		} else if ("/logout.do".equals(pathString)) {
			HttpSession session = req.getSession();
			session.invalidate();    // 세션 초기화
			// redirect 클라이언트에게 요청지시 (데이터 전달 안 됨[원하면 get으로는 가능])
			resp.sendRedirect("index.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService service = UserService.getInstance();
		UserVO user = service.loginUser(req.getParameter("userId")
									  , req.getParameter("userPw"));
		System.out.println(user);
		if(user != null) {
			HttpSession session = req.getSession();
			session.setAttribute("userId", user.getUserId());
			session.setMaxInactiveInterval(5 * 60);   // 5분 (설정 안하면 디폴트 30분)
			resp.sendRedirect("index.jsp");
		} else {
			resp.sendRedirect("login.jsp");
		}
	}

	
}
