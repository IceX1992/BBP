package org.unasat.controller;

import org.unasat.hibernate.dao.HibernateBusDao;
import org.unasat.model.Bus;
import org.unasat.service.RegisterBusService;

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
@WebServlet("/listBusses")
public class OverviewBusController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    //update or delete bus
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Long busId = Long.valueOf(request.getParameter("busid"));
        String brand = request.getParameter("brand");
        Long maxPassengers = Long.valueOf((request.getParameter("max-passenger")));
        String licencePlate = request.getParameter("license-plate");
        Bus bus = new Bus(busId, brand,maxPassengers,licencePlate);

        boolean result;

        try {
            RegisterBusService registerBusService = new RegisterBusService(new HibernateBusDao());

            if (request.getParameter("delete") != null) {
                // DELETE submitted.
                result = registerBusService.delete(bus);
            }else{
                result = registerBusService.update(bus);
            }

            if (result) {
                response.sendRedirect("listBusses");
            } else {
                //error
            }
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("bus_overview.jsp");
        RegisterBusService registerBusService = new RegisterBusService(new HibernateBusDao());
        request.setAttribute("listBusses", registerBusService.getAll());
        dispatcher.forward(request, response);
    }
}
