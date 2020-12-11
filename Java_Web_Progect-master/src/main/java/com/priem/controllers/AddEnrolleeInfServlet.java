package com.priem.controllers;
import com.priem.dao.EnrolleeDao;
import com.priem.dao.LoginDao;
import com.priem.models.Enrollee;

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

public class AddEnrolleeInfServlet extends HttpServlet {
    EnrolleeDao enrolleeDao;

    public AddEnrolleeInfServlet() {
        this.enrolleeDao = new EnrolleeDao();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String dateOfBirth = request.getParameter("birth");

        HttpSession session = request.getSession(false);

        if(session !=null) {
            RequestDispatcher rd = null;
            try {
                boolean result = false;
                String user = (String) session.getAttribute("login");
                Enrollee enrollee = enrolleeDao.selectEnrollee(user);

                if (enrollee == null) {
                    result = enrolleeDao.insertEnrollee(firstName, lastName, email, address, user, dateOfBirth);
                } else {
                    if (!enrollee.isApplied()) {
                        result = enrolleeDao.updateEnrollee(firstName, lastName, email, address, dateOfBirth, user);
                    }
                }
                if (result) {
                    request.setAttribute("saveMsg", "Information was saved successfully.");
                    request.setAttribute("firstName", firstName);
                    request.setAttribute("lastName", lastName);
                    request.setAttribute("email", email);
                    request.setAttribute("address", address);
                    request.setAttribute("dateOfBirth", dateOfBirth);
                } else {
                    request.setAttribute("saveMsg", "Something went wrong. Have you applied document yet?");
                }
            } catch (NamingException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            rd = request.getRequestDispatcher("main.jsp");
            rd.forward(request, response);
            out.close();
        }
    }
}
