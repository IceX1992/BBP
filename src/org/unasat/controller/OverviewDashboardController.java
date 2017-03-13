package org.unasat.controller;

import org.unasat.hibernate.dao.HibernateBusDao;
import org.unasat.hibernate.dao.HibernateBusRouteDao;
import org.unasat.hibernate.dao.HibernateRideDao;
import org.unasat.hibernate.dao.HibernateRouteDao;
import org.unasat.model.Route;
import org.unasat.model.RouteCount;
import org.unasat.service.RegisterBusRouteService;
import org.unasat.service.RegisterBusService;
import org.unasat.service.RegisterRidesService;
import org.unasat.service.RegisterRouteService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by dionc on 3/12/2017.
 */
@WebServlet("/dashboard")
public class OverviewDashboardController extends HttpServlet{

    private static final long serialVersionUID = 1L;


/*    public static void main(String a[]){
        int[] arr1 = {10,34,2,56,7,67,88,42};
        int[] arr2 = doInsertionSort(arr1);
        for(int i:arr2){
            System.out.print(i);
            System.out.print(", ");
        }
    }*/

    public static RouteCount[] doInsertionSort(List<RouteCount> input){

        RouteCount temp;
        RouteCount[] routeCounts = input.toArray(new RouteCount[input.size()]);
        for (int i = 1; i < input.size(); i++) {
            for(int j = i ; j > 0 ; j--){
                if(routeCounts[j].getCount() < routeCounts[j-1].getCount()){
                    temp = routeCounts[j];
                    routeCounts[j] = routeCounts[j-1];
                    routeCounts[j-1] = temp;
                }
            }
        }
        return routeCounts;
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
        RegisterBusService registerBusService = new RegisterBusService(new HibernateBusDao());
        RegisterRidesService registerRidesService = new RegisterRidesService(new HibernateRideDao());
        RegisterRouteService registerRouteService = new RegisterRouteService(new HibernateRouteDao());
        RegisterBusRouteService registerBusRouteService = new RegisterBusRouteService(new HibernateBusRouteDao());

        List<Route> routeList = registerRouteService.getAll();
        List<RouteCount> routeCountList = new ArrayList<RouteCount>();
        List<RouteCount> routeCountList2 = new ArrayList<RouteCount>();
        RouteCount routeCount;
        Long countAllRoutes = 0L;
        Long test;
        String routename = null;
        for(Route route : routeList){
            routename = route.getName();
            test = registerBusRouteService.countRoute(route.getId());
            routeCount = new RouteCount();
            routeCount.setCount(test);
            routeCount.setName(routename);
            countAllRoutes= countAllRoutes + test;
            routeCountList.add(routeCount);
        }
        for(RouteCount routeCount1 : routeCountList){
            routeCount1.setCountPerc(routeCount1.getCount() * 100 / countAllRoutes );
            routeCountList2.add(routeCount1);
        }

        //insert them from lowest number of routes to highes
        RouteCount[] routeCounts = doInsertionSort(routeCountList2);
        List<RouteCount> routeCountList1 = new ArrayList<RouteCount>(Arrays.asList(routeCounts));
        //reverse to highest to low
        Collections.reverse(routeCountList1);
        //we only show top 5 highest, so remove all after the top 5
        for(int i = routeCountList1.size(); i > 5;i--){
            routeCountList1.remove(i-1);
        }
        request.setAttribute("routeCountObject",routeCountList1);
        request.setAttribute("countBus", registerBusService.countBusses());
        request.setAttribute("maxPassengers", registerBusService.getMaxCount());
        request.setAttribute("ridesCount", registerRidesService.countRides());
        request.setAttribute("soldTickets", registerRidesService.getSoldTicketsCount());
        request.setAttribute("lateRides", registerRidesService.getListOfLateRides());
        dispatcher.forward(request, response);
    }
}
