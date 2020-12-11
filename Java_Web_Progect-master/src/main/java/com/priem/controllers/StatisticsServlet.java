package com.priem.controllers;

import com.priem.dao.EnrolleeDao;
import com.priem.models.Enrollee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StatisticsServlet extends HttpServlet {
    EnrolleeDao enrolleeDao;

    public StatisticsServlet() {
        this.enrolleeDao = new EnrolleeDao();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = null;
        List<Enrollee> enrollees = enrolleeDao.selectAllEnrolles();
        request.setAttribute("enrollees", enrollees);
        rd = request.getRequestDispatcher("views/statistics.jsp");
        rd.include(request, response);
    }
}
