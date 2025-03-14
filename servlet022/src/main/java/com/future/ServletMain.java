package com.future;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class ServletMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletMain() {
        super();
    }
	@Override
	public void destroy() {
		System.out.println("종료됨.");
	}
	@Override
	public void init() throws ServletException {
		System.out.println("요청이 왔습니다!!!");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("get 요청됨.");
		res.setContentType("text/html; charset=utf-8");
		res.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		out.println("main 화면 입니다.");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post 요청옴");
		doGet(request, response);
	}

}
