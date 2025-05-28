
package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.DiaryDAO;
import model.DiaryEntry;

@WebServlet("/edit")
public class EditDiaryServlet extends HttpServlet {
    private DiaryDAO diaryDAO = new DiaryDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");

        if (idStr != null) {
            try {
                int id = Integer.parseInt(idStr);
                DiaryEntry entry = diaryDAO.getEntryById(id);
                request.setAttribute("entry", entry);
                request.getRequestDispatcher("edit.jsp").forward(request, response);
            } catch (NumberFormatException e) {
                e.printStackTrace(); // 잘못된 id 처리
                response.sendRedirect("diary");
            }
        } else {
            response.sendRedirect("diary");
        }
    }
}