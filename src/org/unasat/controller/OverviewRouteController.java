package org.unasat.controller;

import org.unasat.hibernate.dao.HibernateRouteDao;
import org.unasat.model.Route;
import org.unasat.service.RegisterRouteService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by dionc on 3/11/2017.
 */
@WebServlet("/listRoutes")
public class OverviewRouteController extends HttpServlet{

    private static final long serialVersionUID = 1L;

    //update or delete bus
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Long routeid = Long.valueOf(request.getParameter("routeid"));
        String name = request.getParameter("name");
        String departure = request.getParameter("departure");
        String destination = request.getParameter("destination");
        Double pricePerPassenger = Double.valueOf((request.getParameter("pricePerPassenger")));
        Route route = new Route(routeid, name,departure,destination,pricePerPassenger);

        boolean result;

        try {
            RegisterRouteService registerRouteService = new RegisterRouteService(new HibernateRouteDao());

            if (request.getParameter("delete") != null) {
                // DELETE submitted.
                result = registerRouteService.delete(route);
            }else{
                result = registerRouteService.update(route);
            }

            if (result) {
                response.sendRedirect("listRoutes");
            } else {
                //error
            }
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("route_overview.jsp");
        RegisterRouteService registerRouteService = new RegisterRouteService(new HibernateRouteDao());
        request.setAttribute("listRoutes", registerRouteService.getAll());
        dispatcher.forward(request, response);
    }

}
