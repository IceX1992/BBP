package org.unasat.controller;

import org.unasat.hibernate.dao.HibernateBusDao;
import org.unasat.hibernate.dao.HibernateRouteDao;
import org.unasat.hibernate.dao.HibernateBusRouteDao;
import org.unasat.model.Bus;
import org.unasat.model.BusRoute;
import org.unasat.model.Route;
import org.unasat.service.RegisterBusRouteService;
import org.unasat.service.RegisterBusService;
import org.unasat.service.RegisterRouteService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dionc on 3/11/2017.
 */
@WebServlet("/listBusRoutes")
public class OverviewBusRouteController extends HttpServlet{

    private static final long serialVersionUID = 1L;

    //update or delete bus
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String estimatedDepartureString = request.getParameter("estimatedDeparture");
        String estimatedDArrivalString = request.getParameter("estimatedDArrival");
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date estimatedDeparture = new Date();
        Date estimatedDArrival = new Date();
        try {
            estimatedDeparture = inputDateFormat.parse(estimatedDepartureString);
            estimatedDArrival = inputDateFormat.parse(estimatedDArrivalString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Long busId = Long.valueOf(request.getParameter("busId"));
        Long routeId = Long.valueOf(request.getParameter("routeId"));
        Bus bus = new HibernateBusDao().getBusByBusId(busId);
        Route route = new HibernateRouteDao().getRouteByRouteId(routeId);
        String busRouteName = bus.getBrand() + " " + bus.getLicencePlate() + " from " + route.getDeparture() + " to " + route.getDestination();
        BusRoute busRoute = new BusRoute(busRouteName, estimatedDeparture, estimatedDArrival,bus,route);

        boolean result;

        try {
            RegisterBusRouteService registerBusRouteService = new RegisterBusRouteService(new HibernateBusRouteDao());

                result = registerBusRouteService.register(busRoute);


            if (result) {
                response.sendRedirect("listBusRoutes");
            } else {
                //error
            }
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("bus_route_overview.jsp");
        RegisterBusRouteService registerBusRouteService = new RegisterBusRouteService(new HibernateBusRouteDao());
        RegisterBusService registerBusService = new RegisterBusService(new HibernateBusDao());
        RegisterRouteService registerRouteService = new RegisterRouteService(new HibernateRouteDao());
        request.setAttribute("listBusRoutes", registerBusRouteService.getAll());
        request.setAttribute("listBusses", registerBusService.getAll());
        request.setAttribute("listRoutes", registerRouteService.getAll());
        dispatcher.forward(request, response);
    }

}
