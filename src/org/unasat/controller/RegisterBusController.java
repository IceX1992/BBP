package org.unasat.controller;

import org.unasat.hibernate.dao.HibernateBusDao;
import org.unasat.model.Bus;
import org.unasat.service.RegisterBusService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by dionc on 3/10/2017.
 */
public class RegisterBusController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    //register a bus
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String brand = request.getParameter("brand");
        Long maxPassengers = Long.valueOf((request.getParameter("maxPassengers")));
        String licencePlate = request.getParameter("licencePlate");

        Bus bus = new Bus(brand,maxPassengers,licencePlate);

        try {
            RegisterBusService registerBusService = new RegisterBusService(new HibernateBusDao());
            boolean result = registerBusService.register(bus);
            if (result) {
                response.sendRedirect("busRegister.html");

            } else {
               //error
            }
        } finally {
            out.close();
        }
    }
}
