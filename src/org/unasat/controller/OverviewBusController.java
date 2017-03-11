package org.unasat.controller;

import org.unasat.hibernate.dao.HibernateBusDao;
import org.unasat.service.RegisterBusService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dionc on 3/11/2017.
 */
@WebServlet("/listBusses")
public class OverviewBusController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("bus_overview.jsp");
        RegisterBusService registerBusService = new RegisterBusService(new HibernateBusDao());
        request.setAttribute("listBusses", registerBusService.getAll());
        dispatcher.forward(request, response);
    }
}
