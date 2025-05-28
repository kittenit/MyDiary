package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.DiaryDAO;

@WebServlet("/delete")
public class DeleteDiaryServlet extends HttpServlet {
    private DiaryDAO diaryDAO = new DiaryDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");

        if (idStr != null) {
            try {
                int id = Integer.parseInt(idStr);
                diaryDAO.deleteEntry(id);
            } catch (NumberFormatException e) {
                e.printStackTrace(); // 問題あるなら
            }
        }

        // 削除してまた戻る
        response.sendRedirect("diary");
    }
}
