package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;

@WebServlet("/user")
public class UserController extends HttpServlet {
    private UserDAO userDAO = new UserDAO();
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String action = request.getParameter("action");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("register".equals(action)) {
        	System.out.println("if");
            boolean success = userDAO.register(username, password);
            if (success) {
                response.sendRedirect("login.jsp");
            } else {
                response.sendRedirect("register.jsp?error=1");
            }
        } else if ("login".equals(action)) {
        	System.out.println("else if");
            User user = userDAO.login(username, password);
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("diary");
            } else {
                response.sendRedirect("login.jsp?error=1");
                
              
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().invalidate(); // ログアウト
        response.sendRedirect("login.jsp");
    }
}