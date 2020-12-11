package com.priem.controllers;

import com.priem.dao.RegisterDao;
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

public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
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
                if (RegisterDao.register(userName, password)) {
                    rd = request.getRequestDispatcher("main.jsp");
                    rd.forward(request, response);
                }
                else {
                    request.setAttribute("registerMsg","Registration failed!");
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
