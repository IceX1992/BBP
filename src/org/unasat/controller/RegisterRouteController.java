package org.unasat.controller;

import org.unasat.hibernate.dao.HibernateBusDao;
import org.unasat.hibernate.dao.HibernateRouteDao;
import org.unasat.model.Bus;
import org.unasat.model.Route;
import org.unasat.service.RegisterBusService;
import org.unasat.service.RegisterRouteService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by dionc on 3/11/2017.
 */
public class RegisterRouteController extends HttpServlet{

    private static final long serialVersionUID = 1L;

    //register a route
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String departure = request.getParameter("departure");
        String destination = request.getParameter("destination");
        Double pricePerPassenger = Double.valueOf((request.getParameter("price_per_passenger")));
        Route route = new Route(name,departure,destination,pricePerPassenger);

        try {
            RegisterRouteService registerRouteService = new RegisterRouteService(new HibernateRouteDao());
            boolean result = registerRouteService.register(route);
            if (result) {
                response.sendRedirect("listRoutes");

            } else {
                //error
                response.sendRedirect("listRoutes");
            }
        } finally {
            out.close();
        }
    }

}
