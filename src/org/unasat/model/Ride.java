package org.unasat.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by dionc on 2/24/2017.
 */
@Entity
@Table(name = "RIDE")
public class Ride {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "actual_departure", nullable = false, columnDefinition = "DATETIME")
    private Date actualDeparture;

    @Column(name = "actual_arrival", nullable = false, columnDefinition = "DATETIME")
    private Date actualArrival;

    @Column(name = "sold_tickets")
    private Long soldTickets;

    @ManyToOne(cascade = CascadeType.ALL)
    private BusRoute busRoute;

    public Ride(Date actualDeparture, Date actualArrival, Long soldTickets, BusRoute busRoute) {
        this.actualDeparture = actualDeparture;
        this.actualArrival = actualArrival;
        this.soldTickets = soldTickets;
        this.busRoute = busRoute;
    }

    public Ride(Long id,Date actualDeparture, Date actualArrival, Long soldTickets, BusRoute busRoute) {
        this.id = id;
        this.actualDeparture = actualDeparture;
        this.actualArrival = actualArrival;
        this.soldTickets = soldTickets;
        this.busRoute = busRoute;
    }

    public Ride() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getActualDeparture() {
        return actualDeparture;
    }

    public void setActualDeparture(Date actualDeparture) {
        this.actualDeparture = actualDeparture;
    }

    public Date getActualArrival() {
        return actualArrival;
    }

    public void setActualArrival(Date actualArrival) {
        this.actualArrival = actualArrival;
    }

    public Long getSoldTickets() {
        return soldTickets;
    }

    public void setSoldTickets(Long soldTickets) {
        this.soldTickets = soldTickets;
    }

    public BusRoute getBusRoute() {
        return busRoute;
    }

    public void setBusRoute(BusRoute busRoute) {
        this.busRoute = busRoute;
    }
}
