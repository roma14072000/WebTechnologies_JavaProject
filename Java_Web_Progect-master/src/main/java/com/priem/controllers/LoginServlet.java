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

public class LoginServlet extends HttpServlet {
    EnrolleeDao enrolleeDao;

    public LoginServlet() {
        this.enrolleeDao = new EnrolleeDao();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("login");
        String password = request.getParameter("password");

        HttpSession session = request.getSession(false);
        if(session !=null) {
            session.setAttribute("login", userName);
            RequestDispatcher rd = null;
            try {
                if (LoginDao.validate(userName, password)) {
                    Enrollee enrollee = enrolleeDao.selectEnrollee(userName);
                    if (enrollee != null) {
                        request.setAttribute("firstName",enrollee.getFirstName());
                        request.setAttribute("lastName",enrollee.getLastName());
                        request.setAttribute("email",enrollee.getEmail());
                        request.setAttribute("address",enrollee.getAddress());
                        request.setAttribute("dateOfBirth",enrollee.getDateOfBirth());
                    }
                    rd = request.getRequestDispatcher("main.jsp");
                    rd.forward(request, response);
                }
                else {
                    if (userName != null) {
                        request.setAttribute("loginMsg","Incorrect login or password!");
                    }
                    rd = request.getRequestDispatcher("index.jsp");
                    rd.include(request, response);
                }
            } catch (NamingException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            out.close();
        }
    }
}

