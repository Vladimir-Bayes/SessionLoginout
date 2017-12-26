package com.yiibai;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("link.html").include(request, response);

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (username == null) {
			username = "";
		}
		if (password == null) {
			password = "";
		}

		if (username.equals("admin") && password.equals("admin123")) {
			out.print("Welcome, " + username);
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("nickname", "苏dark♂牛");
			session.setAttribute("age", "21");
		} else {
			out.print("<font style='color:rec;'>对不起，用户名或密码错误!</font>");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		out.close();
	}

}
