package org.javarush.m3fp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/start")
public class StartQuestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        request.setAttribute("requestAttribute", "Request attribute test");
        request.setAttribute("greeting", "hello world");

        session.setAttribute("sessionAttribute", "Session attribute test");

        getServletContext().getRequestDispatcher("/startQuest.jsp").forward(request, response);
    }
}
