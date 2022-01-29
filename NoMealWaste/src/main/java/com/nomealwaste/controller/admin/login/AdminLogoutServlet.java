package com.nomealwaste.controller.admin.login;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Admin/admin_logout")
public class AdminLogoutServlet extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		HttpSession session = req.getSession();
		session.removeAttribute("username");
		if (session.getAttribute("username") == null) {
			session.invalidate();
			res.sendRedirect("AdminLogin.jsp");
		}

	}

}
