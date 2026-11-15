package com.movieticket.controller.auth;

import com.movieticket.dao.UserDAO;
import com.movieticket.model.UserBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/** Validates registration details and creates a user account. */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final UserDAO userDAO = new UserDAO();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserBean user = new UserBean();

		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setPhone(request.getParameter("phone"));
		user.setRole("USER");
		user.setStatus(true);
		user.setSecurityQuestion(request.getParameter("securityQuestion"));
		user.setSecurityAnswer(request.getParameter("securityAnswer"));

		boolean registered = userDAO.registerUser(user);

		if (registered) {

			response.sendRedirect(request.getContextPath() + "/auth/register.jsp?success=1");

		} else {

			request.setAttribute("error", "Registration failed. Email or phone may already exist.");

			request.getRequestDispatcher("/auth/register.jsp").forward(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect(request.getContextPath() + "/auth/register.jsp");
	}
}