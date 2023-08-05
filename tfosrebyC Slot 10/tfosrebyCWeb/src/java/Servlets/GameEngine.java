/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import User.UserStatics;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author anhbs
 */
public class GameEngine extends HttpServlet {

    int numguess = 0;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "webplay.jsp";
        numguess++;
        HttpSession session = request.getSession();

        int computernum = (int)session.getAttribute("SELECTED_NUMBER");
        String user = (String)session.getAttribute("USER_NAME");
        int userguess = Integer.parseInt(request.getParameter("userguess"));
        System.out.println("number is: " + computernum + " and guess is: " + numguess);

        if (computernum == userguess) {
            numguess = 0;
            request.setAttribute("BINGO", "Congratulations ! The number is: " + computernum);
            List<UserStatics> addmore = (List<UserStatics>) session.getAttribute("USER_LIST");
            if (addmore == null) {
                addmore = new ArrayList<>();
            }
            addmore.add(new UserStatics(user, numguess));

            Collections.sort(addmore);
            session.setAttribute("USER_LIST", addmore);
            request.setAttribute("BINGO", "Congratulations, The number is : "+computernum);
        } else {
            if (userguess < computernum) {
                request.setAttribute("LOWER_NUM", "Failed, Your number is less than the chosen");
            } else {
                request.setAttribute("HIGHER_NUM", "Failed, Your number is higher than the chosen");
            }
        }
        request.getRequestDispatcher(url).forward(request, response);
    }
}
