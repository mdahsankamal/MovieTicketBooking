package com.movieticket.controller.auth;

import com.movieticket.dao.UserDAO;
import com.movieticket.model.UserBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/** Authenticates users and sets up their session. */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final UserDAO userDAO = new UserDAO();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get login details from the form
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (email == null || email.trim().isEmpty()) {

			request.setAttribute("emailError", "Email address is required.");

			request.getRequestDispatcher("/auth/login.jsp").forward(request, response);

			return;
		}

		email = email.trim();

		String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

		if (!email.matches(emailRegex)) {

			request.setAttribute("emailError", "Please enter a valid email address.");

			request.getRequestDispatcher("/auth/login.jsp").forward(request, response);

			return;
		}

		// Check user in database
		UserBean user = userDAO.loginUser(email, password);

		if (user != null) {
			// Create session
			HttpSession session = request.getSession();

			session.setAttribute("user", user);
			session.setAttribute("userId", user.getId());
			session.setAttribute("userName", user.getName());
			session.setAttribute("userRole", user.getRole());
			session.removeAttribute("accountInactive");

			response.sendRedirect(request.getContextPath() + "/home");

		} else {

			request.setAttribute("emailError", "Invalid email or password.");

			request.getRequestDispatcher("/auth/login.jsp").forward(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect(request.getContextPath() + "/auth/login.jsp");
	}

}
