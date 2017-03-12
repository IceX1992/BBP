package org.unasat.controller;

import org.unasat.hibernate.dao.HibernateBusRouteDao;
import org.unasat.hibernate.dao.HibernateRideDao;
import org.unasat.model.BusRoute;
import org.unasat.model.Ride;
import org.unasat.service.RegisterBusRouteService;
import org.unasat.service.RegisterRidesService;

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
 * Created by dionc on 3/12/2017.
 */
@WebServlet("/listRides")
public class OverviewRidesConroller extends HttpServlet{

    private static final long serialVersionUID = 1L;

    //update or delete rides
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String actualDepartureString = request.getParameter("actualDeparture");
        String actualArrivalString = request.getParameter("actualArrival");
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date actualDeparture = new Date();
        Date actualArrival = new Date();
        try {
            actualDeparture = inputDateFormat.parse(actualDepartureString);
            actualArrival = inputDateFormat.parse(actualArrivalString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Long soldTickets = Long.valueOf(request.getParameter("soldTickets"));
        String busRouteName = request.getParameter("name");
        BusRoute busRoute = new HibernateBusRouteDao().getBusRouteByBusRouteName(busRouteName);
        Ride ride = new Ride(actualDeparture,actualArrival,soldTickets,busRoute);

        boolean result;

        try {
            RegisterRidesService registerRidesService = new RegisterRidesService(new HibernateRideDao());
            result = registerRidesService.register(ride);

            if (result) {
                response.sendRedirect("listRides");
            } else {
                //error
            }
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("rides_overview.jsp");
        RegisterBusRouteService registerBusRouteService = new RegisterBusRouteService(new HibernateBusRouteDao());
        RegisterRidesService registerRidesService = new RegisterRidesService(new HibernateRideDao());
        request.setAttribute("listBusRoutes", registerBusRouteService.getAll());
        request.setAttribute("listRides", registerRidesService.getAll());
        dispatcher.forward(request, response);
    }




}
