package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author anhbs
 */
@WebServlet
public class OnlineServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        int min = 1,max = 1000;
        int selected = (int)(Math.random()*(max-min+1)+min);
        HttpSession session = request.getSession();
        session.setAttribute("SELECTED_NUMBER", selected);
        session.setAttribute("USER_NAME", username);
        request.getRequestDispatcher("webplay.jsp").forward(request, response);
    }
}
