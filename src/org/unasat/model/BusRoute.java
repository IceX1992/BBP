package org.unasat.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by dionc on 2/25/2017.
 */
@Entity
@Table(name="BUS_ROUTE")
public class BusRoute{


    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false)
    @NotBlank
    private String busRoute;

    @Column(name = "estimated_departure", nullable = false, columnDefinition = "DATETIME")
    private Date estimatedDeparture;

    @Column(name = "estimated_arrival", nullable = false, columnDefinition = "DATETIME")
    private Date estimatedDArrival;

    @ManyToOne(cascade = CascadeType.ALL)
    private Bus bus;

    @ManyToOne(cascade = CascadeType.ALL)
    private Route route;


    public BusRoute(String busRoute, Date estimatedDeparture, Date estimatedDArrival, Bus bus, Route route) {
        this.busRoute = busRoute;
        this.estimatedDeparture = estimatedDeparture;
        this.estimatedDArrival = estimatedDArrival;
        this.bus = bus;
        this.route = route;
    }

    public BusRoute() {
    }

    public String getBusRoute() {
        return busRoute;
    }

    public void setBusRoute(String busRoute) {
        this.busRoute = busRoute;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getEstimatedDeparture() {
        return estimatedDeparture;
    }

    public void setEstimatedDeparture(Date estimatedDeparture) {
        this.estimatedDeparture = estimatedDeparture;
    }

    public Date getEstimatedDArrival() {
        return estimatedDArrival;
    }

    public void setEstimatedDArrival(Date estimatedDArrival) {
        this.estimatedDArrival = estimatedDArrival;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }





}
