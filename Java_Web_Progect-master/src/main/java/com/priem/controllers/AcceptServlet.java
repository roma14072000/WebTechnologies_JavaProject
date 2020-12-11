package com.priem.controllers;
import com.priem.dao.EnrolleeDao;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class AcceptServlet extends HttpServlet {
    EnrolleeDao enrolleeDao;

    public AcceptServlet() {
        this.enrolleeDao = new EnrolleeDao();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = null;
        Integer langResult = Integer.parseInt(request.getParameter("langResult"));
        Integer mathResult = Integer.parseInt(request.getParameter("mathResult"));
        Integer physResult = Integer.parseInt(request.getParameter("physResult"));
        Integer certificate = Integer.parseInt(request.getParameter("certificate"));
        Integer certificateType = Integer.parseInt(request.getParameter("certificateType"));
        Integer faculty = Integer.parseInt(request.getParameter("faculty"));
        HttpSession session = request.getSession(false);
        String userName = (String) session.getAttribute("login");
        try {
            if (enrolleeDao.acceptEnrollee(langResult, mathResult, physResult, certificate, certificateType, faculty, userName))
            {
                request.setAttribute("acceptMsg","Application was accepted.");
                rd = request.getRequestDispatcher("main.jsp");
                rd.include(request, response);
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
